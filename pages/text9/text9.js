// pages/text9/text9.js
const app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    userid: null, //用户id

    activeIndex: 0,
    sliderOffset: 0,
    votelist: '',
    sliderLeft: 0,
  },
  //用户登录
  userLogin: function (e) {
    //如果用户拒绝的话 就提示
    if (e.detail.userInfo == null) {
      wx.showModal({
        title: '提示',
        content: '授权失败，不可执行此操作!',
      })
      return
    }
    var that = this

    //如果是第一次授权则进行登录，不然就不进行登录操作--可能造成数据更新问题，但是不影响
    if (app.globalData.userid == null) {
      var userinfo = e.detail.userInfo
      app.userLogin(userinfo)
      //console.log(userinfo);
      setTimeout(() => {
        that.setData({
          userid: app.globalData.userid,
        })
      }, 2000)
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {},

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {},

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {},

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {},

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {},

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {},

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {},

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {},
})
