// components/allarticles/allarticles.js
Component({
  /**
   * 页面的初始数据
   */
  data: {
    article: {},
    articalist: [{
      title: "等待一个闪闪发光的你，这是我们的第一篇精选",
      content: "do not go gentle into that good night 不要温顺的走进那个良夜old age should burn and rave at close of day（（虽然）年老应该爆发激情）,"
    }, {
      title: "这是第二篇文章",
      content: "啦啦啦德玛西亚啦啦啦啦啦噜噜噜噜噜噜了来了"
    }, {
      title: "这是第三篇文章",
      content: "啦啦啦德玛西亚啦啦啦啦啦噜噜噜噜噜噜了来了"
    }],
    tagList: ["计算机科学与工程学院", "人工智能", "大数据"],
    images: [],
    watchData: 0,
    likeData: 0,
    commentData: 0,
  },
  lifetimes: {
    attached: function () {
      const images = ["/images/blue.png", "/images/fish.png", "/images/sheep.png", "/images/img2.png"];
      wx.setNavigationBarTitle({
        title: '全部帖子',
      })
      this.setData({
        images: images
      })
    }
  },


  // getArticle: function () {
  //   wx.request({
  //     url: '/data/test1.json',
  //     success: res => {
  //       console.log(res.data)
  //     },
  //     fail: err => {
  //       console.error(err)
  //     }
  //   })
  // }

  /**读取本地文件列表 已失败 */
  // onLoad: function () {
  //   const filePath = `wx.env.USER_DATA_PATH`;
  //   wx.getFileSystemManager().readdir({
  //     dirPath: filePath,
  //     success: res => {
  //       this.setData({
  //         articleList: res.files.filter(file => file.endsWith('.json'))
  //       })
  //     },
  //     fail: err => {
  //       console.error(err)
  //     }
  //   })

  // },
  /*接收传值新增文章 */
  // onLoad: function (options) {
  //   const title = options.title
  //   // 检测路径
  //   const filePath = `${wx.env.USER_DATA_PATH}/${title}.json`
  //   console.log(filePath)
  //   console.log(options)
  //   console.log(title)
  //   wx.getFileSystemManager().readFile({
  //     filePath: filePath,
  //     encoding: `utf-8`,
  //     success: res => {
  //       // 调试是否读取到了数据
  //       console.log(res.data)
  //       this.setData({
  //         article: JSON.parse(res.data)
  //       })
  //     },
  //     fail: err => {
  //       console.error(err)
  //     }
  //   })
  // },

})