// components/allarticles/allarticles.js
Component({
  /**
   * 页面的初始数据
   */
  data: {
    article: {},
    articalist: [{
      id: "1",
      title: "等待一个闪闪发光的你，这是我们的第一篇精选",
      content: `思念如马，自别离，未停蹄——《留骏赠妇诗三首》\n秦嘉不主动找你，不是因为你不重要，而是我知道我不重要。以及，我渴望见你一面，但请你记得，我不会开口要见你，不是因为我骄傲，在你面前我毫无骄傲可言，而是因为，只有在你也想见我的时候，我们的见面才有意义。——《越洋情书》西蒙·波娃\n昨日种种，皆成今我，切莫思量，更莫哀，从今往后，怎么收获怎么栽。——《胡适文存》胡适青春是丛林，是荒原，是阳光炙热的奔跑，是大雨滂沱的伫立。—《从你的全世界路过》张嘉佳\n生命里第一个爱恋的对象，应该是自己写诗给自己，与自己对话。在一个空间里安静下来，聆听自己的心跳与呼吸。《依水而局的构树》\n孤独是一个陪伴人一生的伙伴，是一个既定事实，与其否认，与其抗争，与其无谓的逃避，不如接受它，拥挤的人群里让它保护你回家，周六的上午让它陪你吃早餐，整理阳光。——《百年孤独》没事，只不过是恢复原状罢了，我本来就是一无所有的。——濑川初原成年人连崩溃都得体面些。于是，每天每天，我的脸上虽然充斥着淡然的麻木，但我的胸腔里，却时刻回响着巨大的悲鸣。——《我在精神病院抗抑郁》\n人生就是不断的放下，然而痛心的是，我还没来得及与你们好好告别。——《少年派的奇幻漂流》与恶龙缠斗过久，自身亦成为恶龙；凝视深渊过久，深渊将回以凝视。 ——尼采 当我们是最大为谦卑的时候，便是我们最近于伟大的时候。——泰戈尔`
    }, {
      id: "2",
      title: "这是第二篇文章",
      content: `啦啦啦德玛西亚啦啦啦啦啦噜噜噜噜噜噜了来了`
    }, {
      id: "3",
      title: "这是第三篇文章",
      content: `啦啦啦德玛西亚啦啦啦啦啦噜噜噜噜噜噜了来了`
    }],
    tagList: ["计算机科学与工程学院", "人工智能", "大数据"],
    images: [],
    watchData: 0,
    likeData: 0,
    commentData: 0,
    follow: false,
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
  methods: {
    goToArticle: function (e) {
      const articleId = e.currentTarget.dataset.id;
      console.log(articleId)
      const article = this.data.articalist.find(item => item.id === articleId);
      wx.navigateTo({
        url: `/components/allarticles/articlepage/articlepage?id=${article.id}&title=${article.title}&content=${article.content}`,
        // events: events,
        // success: (result) => {},
        // fail: (res) => {},
        // complete: (res) => {},
      })
    },
    isfollow: function () {
      const flag = this.data.flag;
      this.setData({
        flag: !flag,
      })
    }
  }

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