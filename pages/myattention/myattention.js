// pages/myattention/myattention.js
const app = getApp(); // 获取小程序实例对象
const userid = app.globalData.userid; // 从全局数据对象中获取userid变量
const host = app.globalData.host; // 从全局数据对象中获取host变量

Page({

  /**
   * 页面的初始数据
   */
  
  data: {
    selectedCategory: 'project',
    lenxm:0,
    lenjl:0,
     scxm:[],
    scjl:[]
  },
  onSelectCategory(e) {
    const category = e.currentTarget.dataset.category;
    this.setData({
      selectedCategory: category
    });
    console.log(category);
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    const newTitle ='我 的 关 注';
    console.log(app.globalData.userid);
    console.log(app.globalData.userid);
    console.log(app.globalData.userid);
    wx.setNavigationBarTitle({
      title: newTitle
    });
    wx.setNavigationBarColor({
      frontColor: '#ffffff', // 前景颜色为白色
      backgroundColor: '#63cfe2' // 背景色为蓝色
    })
    this.getscjl();
    this.getscxm();
  },

  //获取收藏项目
  getscxm(){
    wx.request({
      url:"http://localhost/index.php/hzu-wechat-mini-program?scene=get_myproject_favorites&id="+app.globalData.userid,
   //   data:{"scene":"get_project_list"},
      success: res=>{
        console.log(res);
        this.setData({
          scxm:res.data,
          lenxm: res.data.length,
        })

      }        
    })
  },

  //获取收藏简历
  getscjl(){
    wx.request({
      url:"http://localhost/index.php/hzu-wechat-mini-program?scene=get_myresume_favorites&id="+app.globalData.userid,
   //   data:{"scene":"get_project_list"},
      success: res=>{
        console.log(res);
        this.setData({
          scjl:res.data,
          lenjl:res.data.length,
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})