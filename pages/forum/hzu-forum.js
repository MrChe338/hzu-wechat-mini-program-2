// pages/forum/hzu-forum.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "navigationBarTitleText": "",
    tabs: [],
    activeTab: 0,
    itemList: [],
    pageNumber: 1,
    date: "",

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    wx.setNavigationBarTitle({
      title: '论坛',
    })
    const titles = ["首页", "全部帖子", "关注"];
    const tabs = titles.map(item => ({
      title: item
    }))

    /* titles = [{"首页"},{"好友"}] */
    this.setData({
      tabs
    })

  },
  onTabChange(e) {
    const index = e.detail.index
    this.setData({
      activeTab: index
    })
  },
  onChange(e) {
    const index = e.detail.index
    this.setData({
      activeTab: index
    })
  },
  navigateToTarget: function () {
    wx.navigateTo({
      url: '/pages/forum/articles/articles',
    })
  },
  navigateToTarget1: function () {
    wx.navigateTo({
      url: '../../components/forumpage/forumpage',
    })
  },
  navigateToTarget2: function () {
    wx.navigateTo({
      url: '../../components/myforum/myforum',
    })
  },
  navigateToTarget3: function () {
    wx.navigateTo({
      url: '../../components/forumpage/forumpage',
    })
  },
  addItem: function (e) {
    const itemList = e.detail
    // console.log(e)
    // console.log(itemList)
    this.setData({
      itemList: itemList
    })
  },


  /** */


  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {},


})

function getCurrentTime() {
  var now = new Date()
  var year = now.getFullYear()
  var month = now.getMonth() + 1
  var day = now.getDate()
  var hour = now.getHours()
  var minute = now.getMinutes()
  var second = now.getSeconds()
  return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second
}