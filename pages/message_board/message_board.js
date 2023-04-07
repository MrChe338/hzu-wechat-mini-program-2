Page({
  data: {
    messageCount: 0,
    messages: [],
    inputValue: '',
    userInfo: {}
  },

  onLoad: function () {
    this.getUserInfoAndFetchMessages();
  },

  getUserInfoAndFetchMessages: function() {
    var that = this;
    wx.getUserProfile({
      desc: '获取您的昵称和头像以显示在留言板上',
      success: function (res) {
        console.log('获取用户信息成功', res.userInfo);
        that.setData({
          userInfo: {
            nickName: res.userInfo.nickName,
            avatarUrl: res.userInfo.avatarUrl
          }
        });
        that.fetchMessages();
      },
      fail: function (res) {
        console.log('获取用户信息失败', res);
      }
    });
    wx.login({
      success: function (res) {
        wx.request({
          url: 'https://api.weixin.qq.com/sns/jscode2session',
          data: {
            appid: 'wx17ba6b6d418b3d77',
            secret: 'dae5a2ebf44cf32ae64086ebb1a6739a',
            js_code: res.code,
            grant_type: 'authorization_code'
          },
          success: function (res) {
            console.log('获取openid成功', res.data.openid); 
            that.setData({
              userInfo: {
                ...that.data.userInfo,
                openid: res.data.openid
              }
            });
          },
          fail: function (res) {
            console.log('获取openid失败', res);
          }
        })
      },
      fail: function(res) {
        console.log('微信登录失败', res);
      }
    });
  },

  fetchMessages: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:3000/api/messages',
      method: 'GET',
      success: function (res) {
        if (res.data.status === 'success') {
          that.setData({
            messageCount: res.data.count,
            messages: res.data.messages
          });
        } else {
          console.error('获取留言失败');
        }
      },
      fail: function () {
        console.error('获取留言失败');
      }
    });
  },

  inputHandler: function (e) {
    this.setData({
      inputValue: e.detail.value
    });
  },

  submitHandler: function () {
    if (this.data.inputValue === '') {
      wx.showToast({
        title: '请输入留言内容',
        icon: 'none'
      });
      return;
    }

    var that = this;
    wx.request({
      url: 'http://localhost:3000/api/messages',
      method: 'POST',
      data: {
        content: this.data.inputValue,
        openid: this.data.userInfo.openid,
        user_name: this.data.userInfo.nickName,
        user_avatar: this.data.userInfo.avatarUrl
      },
      success: function (res) {
        if (res.data.status === 'success') {
          wx.showToast({
            title: '留言成功',
            icon: 'success'
          });
          that.setData({
            inputValue: ''
          });
          that.fetchMessages();
        } else {
          console.error('留言失败');
        }
      },
      fail: function () {
        console.error('留言失败');
      }
    });
  }
});
