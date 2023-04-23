// components/forumpage/forumpage.js
Component({
  // options: {
  //   addGlobalClass: true
  // },
  data: {
    activeTab: 0,
    recAuTab: [],
    topic: ["#五一假期", "#天梯赛", "#大学生创新创业大赛", "#蓝桥杯"],
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
    likeData: 0,
    commentData: 0,
    images: [],
  },
  properties: {
    recAuTab: Array,
    activeTab: Number
  },
  methods: {
    swiperNav: function (e) {
      this.setData({
        'swiperNav.i': e.target.dataset.i
      })
    },

  },
  lifetimes: {
    attached: function () {
      const recAtitles = ["blue", "Fish", "Sheep", "Bobby", "hhh"]
      const images = ["/images/blue.png", "/images/fish.png", "/images/sheep.png", "/images/img2.png", "/images/flower (4).png"]
      const images1 = ["/images/flower2.png", "/images/flower5.png", "/images/flower6.png", "/images/flower4.png"]
      const recAuTab = recAtitles.map((item, index) => ({
        title: item,
        imgUrl: images[index],

      }));

      this.setData({
        recAuTab,
        images: images1
      })
    }
  },
  // onLoad: function () {
  //   const recAtitles = ["blue", "Fish", "Sheep", "mengzhu", "xuanxu"]
  //   const recAuTab = recAtitles.map(item => ({
  //     title: item
  //   }));
  //   this.setData({
  //     recAuTab
  //   })
  // },

})