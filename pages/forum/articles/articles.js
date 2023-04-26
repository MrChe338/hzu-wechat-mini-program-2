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
    taglist: "",
    imglist: "",
    filepath: [],
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
  chooseImg: function (e) {
    const that = this;
    const filepath = [];
    wx.chooseMedia({
      count: 9,
      mediaType: ['image', 'video'],
      sourceType: ['album', 'camera'],
      maxDuration: 30,
      camera: 'back',
      success(res) {
        const tempFiles = res.tempFiles;
        for (let i = 0; i < res.tempFiles.length; i++) {
          filepath.push(tempFiles[i].tempFilePath);
        }
        console.log(filepath[0])
        that.setData({
          filepath: filepath
        })
      },
    })
  }
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