// components/myforum/myforum.js
Page({

  data: {
    myfollow: 1,
    collected: 1,
    ptabs: [],
  },
  // lifetimes: {
  //   attached: function () {
  //     wx.setNavigationBarTitle({
  //       title: '我 的 论 坛',
  //     })
  //     const tabs = ["我的发布", "我的收藏", "我的关注"];
  //     this.setData({
  //       tabs: tabs,
  //     })
  //   }
  // }
  onLoad: function () {
    wx.setNavigationBarTitle({
      title: '我 的 论 坛',
    })
    const titles = ["我的发布", "我的收藏", "我的关注"];
    const tabs = titles.map(item => ({
      title: item
    }))
    // const tabs = [{
    //   "item": 1
    // }, {
    //   "item": 2
    // }]
    console.log(tabs)
    this.setData({
      tabs: tabs
    })

  },

  onTabCLick(e) {
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
  }

})