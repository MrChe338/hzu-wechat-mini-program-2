// components/myfollow/myfollow.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name: ["blue", "fish"],
    flag: false,
    bio: ["这里没有简介呢"],

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  isfollow: function () {
    const flag = this.data.flag;
    this.setData({
      flag: !flag,
    })
  }
})