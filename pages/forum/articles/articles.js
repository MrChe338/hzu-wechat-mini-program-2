// pages/forum/articles.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "navigationBarTitleText": "",
    userInfor: {},
    title: "",
    content: "",

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    wx.setNavigationBarTitle({
      title: '发 帖',
    })
    wx.getUserInfo({
      success: res => {
        this.setData({
          userInfor: res.userInfo
        })
      }
    })
  },
  sumbitForm: function (e) {
    wx.navigateTo({
      url: '../../../components/allarticles/allarticles',
    })
  },

  // sumbitForm: function (e) {
  //   const title = e.detail.value.title;
  //   const content = e.detail.value.content;
  //   const userInfo = this.data.userInfo;
  //   console.log(title, content, userInfo)
  //   wx.getFileSystemManager().access({
  //     path: `${wx.env.USER_DATA_PATH}/${title}.json`,
  //     success: res => {
  //       wx.showToast({
  //         title: '文章已存在'
  //       })
  //     },
  //     fail: err => {
  //       wx.getFileSystemManager().writeFile({
  //         filePath: ``,
  //         data: JSON.stringify({
  //           title: title,
  //           content: content,
  //           userInfo: userInfo
  //         }),
  //         success: res => {
  //           wx.showToast({
  //             title: 'success',
  //           })
  //           // wx.navigateTo({
  //           //   url: '../../../components/allarticles/allarticles?titile={{title}}',
  //           // })
  //         },
  //         fail: err => {
  //           console.error(err)
  //         }
  //       })
  //     },
  //   })
  // },

})