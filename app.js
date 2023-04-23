// app.js

App({
  globalData:{
    userinfo:null,
    userid:1,
    host:"http://localhost/",
  },
  //用户登录
  userLogin: function (userinfo) {
    wx.showLoading({
      title: '登陆中...',
    })
    //处理userinfo中的表情
    // userinfo.nickName = this.fliteremoji(userinfo.nickName);
    //全局变量
    this.globalData.userInfo = userinfo;
    console.log(userinfo);
    var that = this;
    //登录注册_没有用户的id
    wx.login({
      success: function (res) {
        if (res.code) {
          //发起网络请求
          wx.request({
            url: that.globalData.host + "hzu-wechat-mini-program/",
            data: {
              "scene": "user_login",
              'code': res.code,
              "userinfo": that.globalData.userInfo
            },
            success: function (e) {
              //返回userid 用户评论
              that.globalData.userid = e.data;
              console.log(e.data)
              wx.hideLoading();
            }
            , fail: function () {
              wx.hideLoading();

              wx.showToast({
                title: '登陆失败!',
                duration: 2000,
              })
            }
          });
        } else {


          wx.hideLoading();

          wx.showToast({
            title: '登陆失败!',
            duration: 2000,
          })
        }

      },
      fail: function () {
        wx.hideLoading();
      }
    });
  },
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
  }
})
