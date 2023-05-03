const app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    // 性别信息
    // 控制性别显示
    showGender: false,
    sex: ['女', '男'],
    index: null,
    // defaultGender: '',
    // 专业信息
    showMajor: true,
    majorArray: [
      ['19级', '20级', '21级', '22级'],
      [
        '电子信息与电气工程学院',
        '地理与旅游学院',
        '化学与材料工程学院',
        '经济管理学院',
        '建筑与土木工程学院',
        '教育科学学院',
        '美术与设计学院',
        '数学与统计学院',
        '生命科学学院',
        '体育学院',
        '外国语学院',
        '文学与传媒学院',
        '旭日广东服装学院',
        '计算机科学与工程学院',
        '音乐学院',
        '政法学院',
        '马克思主义学院',
      ],
      ['机械电子工程', '电子信息工程', '电气工程及其自动化', '功能材料', '物理学(师范)'],
    ],
    majorIndex: [0, 0, 0],
    // 个人标签
    // 背景图
    showImage: true,
    // 一句话高光
    // 字数限制
    wordMaxWord: 25,
    currentIntroductionWord: 0,
    currentIntentionWord: 0,
    // 项目意向
    intentionMaxWord: 2000,
    // 附件
    showFile: false,
    fileName: '',
    filePath: '',
    chosen: '',
    // 传递的数据
    name: '',
    gender: '',
    grade: '',
    college: '',
    major: '',
    tags: '',
    background_img: 'https://i.328888.xyz/2023/04/18/iz3kqN.jpeg',
    introduction: '',
    skills: '',
    hobbies: '',
    projects: '',
    awards: '',
    others: '',
    project_intention: '',
    attachments: '',
    is_into_talent_pool: 1,
  },
  null() {},
  // 获取姓名name
  handleName(e) {
    const name = e.detail.value
    this.setData({ name })
    // console.log(name)
  },
  // 性别选择器事件,并获取userid
  handleGender(e) {
    const gender = e.detail.value
    this.setData({
      index: e.detail.value,
      showGender: true,
      gender,
    })
    // console.log(gender)
  },
  // 专业多项选择器事件并获取年级、学院、专业数据
  bindPickerChange: function (e) {
    const grade = this.data.majorArray[0][e.detail.value[0]]
    const college = this.data.majorArray[1][e.detail.value[1]]
    const major = this.data.majorArray[2][e.detail.value[2]]
    this.setData({
      majorIndex: e.detail.value,
      college,
      grade,
      major,
    })
    // console.log(grade)
    // console.log(college)
    // console.log(major)
  },
  // 专业多项选择器事件
  bindPickerColumnChange: function (e) {
    // 修改的列为e.detail.column    值为e.detail.value
    const data = {
      majorArray: this.data.majorArray,
      majorIndex: this.data.majorIndex,
    }
    data.majorIndex[e.detail.column] = e.detail.value
    switch (e.detail.column) {
      case 1: //修改的第2列(学院)
        //   第3列跟随第二列相应影响
        switch (data.majorIndex[1]) {
          case 0: //电子学院
            data.majorArray[2] = ['机械电子工程', '电子信息工程', '电气工程及其自动化', '功能材料', '物理学(师范)']
            break
          case 1: //地旅
            data.majorArray[2] = ['地理信息科学', '旅游管理', '地理科学(师范)']
            break
          case 2: //化学
            data.majorArray[2] = ['高分子材料与工程', '化学(师范)', '应用化学', '化学工程与工艺']
            break
          case 3: //经管
            data.majorArray[2] = ['财务管理', '物流管理', '国际经济与贸易', '审计学']
            break
          case 4: //建土
            data.majorArray[2] = ['工程管理', '风景园林', '建筑学', '土木工程']
            break
          case 5: //教育
            data.majorArray[2] = ['学前教育(师范，中外合作办学)', '小学教育(师范)', '学前教育(师范)']
            break
          case 6: //美术
            data.majorArray[2] = ['视觉传达设计', '环境设计', '产品设计', '美术学(师范)']
            break
          case 7: //数学
            data.majorArray[2] = ['数学与应用数学(师范)', '数据科学与大数据技术', '应用统计学']
            break
          case 8: //生科
            data.majorArray[2] = ['生物科学(师范)', '生物技术', '园林']
            break
          case 9: //体育
            data.majorArray[2] = ['体育教育(师范)']
            break
          case 10: //外语
            data.majorArray[2] = ['英语(师范)', '日语']
            break
          case 11: //文传
            data.majorArray[2] = ['网络与新媒体', '汉语言文学(师范)']
            break
          case 12: //服装
            data.majorArray[2] = ['表演(服装表演方向)', '服装设计与工程', '服装与服饰设计']
            break
          case 13: //计科
            data.majorArray[2] = ['网络空间安全', '计算机科学与技术', '软件工程', '网络工程']
            break
          case 14: //音乐
            data.majorArray[2] = ['音乐表演', '音乐学(师范)']
            break
          case 15: //政法
            data.majorArray[2] = ['历史学(师范)', '法学', '社会工作']
            break
          case 16: //马克思
            data.majorArray[2] = ['思想政治教育(师范)']
            break
        }
        break
    }
    this.setData(data)
    this.setData({
      showMajor: false,
    })
  },
  // 获取个人标签
  handleTags(e) {
    const tags = e.detail.value
    this.setData({ tags })
    // console.log(tags)
  },
  // 背景图
  chooseImage: function (e) {
    var that = this
    wx.chooseImage({
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        console.log(res)
        wx.showLoading({
          title: '上传中...',
        })
        var tempFilePaths = res.tempFilePaths
        that.setData({
          showImage: false,
        })
        // 上传
        wx.uploadFile({
          url: 'http://47.113.185.238:8080/upload/', //仅为示例，非真实的接口地址
          filePath: tempFilePaths[0],
          name: 'file',
          formData: {
            'userid': 1,
          },
          success: function (res) {
            var data = res.data
            //do something
            that.setData({
              background_img: 'http://47.113.185.238:8080/' + data,
              showImage: false,
            })
            // console.log(image);
            wx.hideLoading()
          },
          fail: function () {
            wx.showModal({
              title: 'prompt',
              content: 'uploadfile fail!',
            })
            wx.hideLoading()
          },
        })
      },
    })
  },

  // 一句话高光
  // 字数限制
  limitIntroductionWord(e) {
    //解析字符串长度转换成整数。
    const wordLength = parseInt(e.detail.value.length)
    if (wordLength > this.data.maxWord) {
      return
    }
    this.setData({
      currentIntroductionWord: wordLength,
    })
  },

  // 获取数据
  handleIntroduction(e) {
    const introduction = e.detail.value
    this.setData({ introduction })
    // console.log(introduction)
  },
  // 获取详细介绍内容
  handleSkills(e) {
    const skills = e.detail.value
    this.setData({ skills })
    // console.log(skills)
  },
  handleHobbies(e) {
    const hobbies = e.detail.value
    this.setData({ hobbies })
    // console.log(hobbies)
  },
  handleProjects(e) {
    const projects = e.detail.value
    this.setData({ projects })
    // console.log(projects)
  },
  handleAwards(e) {
    const awards = e.detail.value
    this.setData({ awards })
    // console.log(awards)
  },
  handleOthers(e) {
    const others = e.detail.value
    this.setData({ others })
    // console.log(others)
  },
  // 项目意向字数限制
  limitIntentionWordWord(e) {
    //解析字符串长度转换成整数。
    const wordLength = parseInt(e.detail.value.length)
    if (wordLength > this.data.intentionMaxWord) {
      return
    }
    this.setData({
      currentIntentionWord: wordLength,
    })
  },
  handleProjectIntention(e) {
    const project_intention = e.detail.value
    this.setData({ project_intention })
    // console.log(project_intention)
  },
  // 附件上传
  choosefile: function (e) {
    var that = this
    wx.chooseMessageFile({
      count: 1, // 可以选择文件的数量
      type: 'file', // 选择文件类型，这里是选择任意文件类型
      extension: ['pdf', 'docx', 'pptx'],
      success: function (res) {
        var tempFilePath = res.tempFiles[0].path // 文件本地临时路径
        that.setData({
          showFile: true,
          fileName: res.tempFiles[0].name,
        }),
          wx.uploadFile({
            url: 'http://47.113.185.238:8080/upload', // 上传文件的接口地址
            filePath: tempFilePath, // 需要上传的文件路径
            name: 'file', // 文件对应的 key，后端接口根据这个 key 获取文件内容
            formData: {   // 其他需要上传的参数，可自定义
              'userid': 1,
            },
            success: function (res) {
              console.log(res.data) // 服务器返回的文件地址，可以根据需要进行处理
              that.setData({
                attachments: 'http://47.113.185.238:8080/' + res.data,
              })
              wx.hideLoading()
            },
            fail: function () {
              wx.showModal({
                title: 'prompt',
                content: 'uploadfile fail!',
              })
              wx.hideLoading()
            },
          })
      },
    })
  },
  openFile() {
    const that = this
    wx.downloadFile({
      url: that.data.attachments,
      success(res) {
        const filePath = res.tempFilePath
        wx.openDocument({
          filePath: filePath,
        })
      },
    })
  },
  deleteFile() {
    this.setData({
      showFile: false,
      fileName: '',
      attachments: '',
    })
  },
  // 重置
  formReset(e) {
    this.setData({
      name: '',
      gender: '',
      grade: '',
      college: '',
      major: '',
      tags: '',
      background_img: 'https://i.328888.xyz/2023/04/18/iz3kqN.jpeg',
      introduction: '',
      skills: '',
      hobbies: '',
      projects: '',
      awards: '',
      others: '',
      project_intention: '',
      attachments: '',  
      chosen: '',
      currentIntroductionWord: 0,
      currentIntentionWord: 0,
      showGender: false,
      showMajor: true,
      showImage: true,
      showFile: false,
    })
  },

  // 预览（完成）
  handleView() {
    const that = this
    const resumeData = {
      name: that.data.name,
      gender: that.data.gender,
      grade: that.data.grade,
      college: that.data.college,
      major: that.data.major,
      tags: that.data.tags,
      background_img: that.data.background_img,
      introduction: that.data.introduction,
      skills: that.data.skills,
      hobbies: that.data.hobbies,
      awards: that.data.awards,
      projects: that.data.projects,
      others: that.data.others,
      fileName: that.data.fileName,
      project_intention: that.data.project_intention,
      attachments: that.data.attachments,
    }
    wx.setStorage({
      //存储到本地（可以获得数组数据）
      key: 'storageResumeData',
      data: resumeData,
      success(res) {
        // console.log('successStorage', resumeData)
      },
    })
  },
  // 缓存到本地，并把数据给后台并且传0
  handletempSave() {
    const that = this
    wx.showModal({
      title: '缓存',
      content: '确认提交',
      cancelText: '取消',
      confirmText: '确认',
      success(res) {
        if (res.confirm) {
          // console.log('用户点击确定')
          // 本地存储数据
          const resumepack = {
            name: that.data.name,
            gender: that.data.gender,
            grade: that.data.grade,
            college: that.data.college,
            major: that.data.major,
            tags: that.data.tags,
            background_img: that.data.background_img,
            introduction: that.data.introduction,
            skills: that.data.skills,
            hobbies: that.data.hobbies,
            awards: that.data.awards,
            projects: that.data.projects,
            others: that.data.others,
            fileName: that.data.fileName,
            project_intention: that.data.project_intention,
            attachments: that.data.attachments,
            index: that.data.index,
            currentIntroductionWord: that.data.currentIntroductionWord,
            currentIntentionWord: that.data.currentIntentionWord,
            showGender: that.data.showGender,
            showMajor: that.data.showMajor,
            showImage: that.data.showImage,
            showFile: that.data.showFile,
            is_into_talent_pool: 0,
          }
          wx.setStorage({
            //存储到本地（可以获得数组数据）
            key: 'storageResumeData',
            data: resumepack,
            success(res) {
              // 成功存储至本地
              // console.log('storageSuccess', resumeData)
            },
          })
          // 将数据传给后台不投入人才库
          wx.request({
            method: "POST",
            url: `http://47.113.185.238:8080/resume/save`,
            header: {
              'content-type': 'application/json'
            },
            data: {
              "user": {"id": 1},
              "name": that.data.name,
              "gender": that.data.gender,
              "grade": that.data.grade,
              "college": that.data.college,
              "major": that.data.major,
              "tags": that.data.tags,
              "backgroundImg": that.data.background_img,
              "introduction": that.data.introduction,
              "skills": that.data.skills,
              "hobbies": that.data.hobbies,
              "projects": that.data.projects,
              "awards": that.data.awards,
              "others": that.data.others,
              "projectIntention": that.data.project_intention,
              "attachments": that.data.attachments,
              "isIntoTalentPool": 0
            },
            success: function (rsp) {
              console.log(rsp.data)
            },
            fail: function () {
              wx.showModal({
                title: '提示',
                content: '发布失败！',
              })
            },
          })
        // 弹窗提示保存成功
          wx.showToast({
            title: '保存成功',
            icon: 'success',
          })
        } else if (res.cancel) {
          // console.log('用户点击取消')
        }
      },
    })
  },
  //保存到本地，并把数据给后台并且传1
  handleSave(e) {
    const that = this
    // 若必填信息不完整则弹窗提示请输入必填信息
    if (
      // 6个必填信息，都不能为空
      this.data.name == '' ||
      this.data.gender == '' ||
      this.data.college == '' ||
      this.data.grade == '' ||
      this.data.major == '' ||
      this.data.introduction == ''
    ) {
      wx.showToast({
        title: '请输入必填信息',
        icon: 'none',
      })
    } else {
      wx.showModal({
        title: '提示',
        content: '确认提交',
        cancelText: '取消',
        confirmText: '确认',
        success(res) {
          console.log(res)
          if (res.confirm) {
            // console.log('用户点击确定')
            const resumepack = {
              name: that.data.name,
              gender: that.data.gender,
              grade: that.data.grade,
              college: that.data.college,
              major: that.data.major,
              tags: that.data.tags,
              background_img: that.data.background_img,
              introduction: that.data.introduction,
              skills: that.data.skills,
              hobbies: that.data.hobbies,
              awards: that.data.awards,
              projects: that.data.projects,
              others: that.data.others,
              fileName: that.data.fileName,
              project_intention: that.data.project_intention,
              attachments: that.data.attachments,
              index: that.data.index,
              currentIntroductionWord: that.data.currentIntroductionWord,
              currentIntentionWord: that.data.currentIntentionWord,
              showGender: that.data.showGender,
              showMajor: that.data.showMajor,
              showImage: that.data.showImage,
              showFile: that.data.showFile,
              is_into_talent_pool: 1,
            }
            wx.setStorage({
              //存储到本地（可以获得数组数据）
              key: 'storageResumeData',
              data: resumepack,
              success(res) {
                // 成功存储至本地
                // console.log('storageSuccess', resumeData)
              },
            })
            // 将数据传给后台并投入人才库
            wx.request({
              method: "POST",
              url: `http://47.113.185.238:8080/resume/save`,
              header: {
                'content-type': 'application/json'
              },
              data: {
                "user": {"id": 1},
                "name": that.data.name,
                "gender": that.data.gender,
                "grade": that.data.grade,
                "college": that.data.college,
                "major": that.data.major,
                "tags": that.data.tags,
                "backgroundImg": that.data.background_img,
                "introduction": that.data.introduction,
                "skills": that.data.skills,
                "hobbies": that.data.hobbies,
                "projects": that.data.projects,
                "awards": that.data.awards,
                "others": that.data.others,
                "projectIntention": that.data.project_intention,
                "attachments": that.data.attachments,
                "isIntoTalentPool": 1
              },
              success: function (rsp) {
                console.log(rsp.data)
              },
              fail: function () {
                wx.showModal({
                  title: '提示',
                  content: '发布失败！',
                })
              },
            })
            wx.showModal({
              content: '创建成功',
              success(res) {},
              fail(res) {},
              showCancel: false,
              confirmText: '确定', //默认是“确定”
            })
          } else if (res.cancel) {
            // console.log('用户点击取消')
          }
        },
      })
    }
  },
  // 清空缓存  （存在问题）
  handleClear(e) {
    wx.showToast({
      title: '清除缓存成功',
      icon: 'success',
    })
    this.formReset(e) //点击的时候就触碰到了该事件（未解决）
    wx.clearStorage()
  },
  /**
   * 生命周期函数--监听页面加载  若本地有缓存数据，则加载
   */
  onLoad(options) {
    const that = this
    // 查看是否有本地缓存数据
    wx.getStorage({
      key: 'storageResumeData',
      success(res) {
        // 有数据时弹出询问是否需要加载
        wx.showModal({
          title: '检测到存有缓存',
          content: '是否加载缓存简历',
          cancelText: '取消',
          confirmText: '确认',
          success(res) {
            console.log(res)
            if (res.confirm) {
              // console.log('用户点击确定')
              wx.getStorage({
                key: 'storageResumeData',
                success(res) {
                  that.setData({
                    ...res.data,
                  })
                },
              })
            } else if (res.cancel) {
              // console.log('用户点击取消')
              // 清除本地缓存
              wx.clearStorage()
            }
          },
        })
      },
    })
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
