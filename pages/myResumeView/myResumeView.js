Page({
  /**
   * 页面的初始数据
   */
  data: {},
  // 文件不提供浏览弹窗
  showFail() {
    wx.showToast({
      title: '此处不提供浏览',
      icon: 'error',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    const that = this
    // 取本地存储的数据
    wx.getStorage({
      key: 'storageResumeData',
      success(res) {
        that.setData({
          storageResumeData: res.data,
        })
      },
    })
    // 读取数据后加工处理
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {},

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {},

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {},

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {},

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {},

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {},

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {},
})
