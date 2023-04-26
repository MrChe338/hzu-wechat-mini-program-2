// components/allarticles/articlepage/articlepage.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    article: {},
    id: "",
    title: "",
    content: "",
    flag: false,
    taglist: ["计算机科学与工程学院", "文学", "名人名言"]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    const id = options.id;
    const title = options.title;
    const content = options.content;
    console.log(id, title, content)
    this.setData({
      id: id,
      title: title,
      content: content
    })
    wx.setNavigationBarTitle({
      title: title,
    })
  },
  isfollow: function () {
    const flag = this.data.flag;
    this.setData({
      flag: !flag,
    })
  }

})