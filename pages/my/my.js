Page({
  data:{
    items:[],
    result: [],
    page:1,
    pageSize:10,
    total:0,
    isloading:false
  },
  onLoad() {
    //我们写一个调用数据库函数，使得本页面加载时调用此函数，查找 youqi.data 里的所有条目。
        wx.request({
            method: 'GET',//这里要和 server.js 定义的 post or get 一致！！！
            url: 'http://10.77.73.240:3000/getUser',//这里的 ip 地址不是数据库的地址，而是你的电脑本地的地址，因为这一步的操作是要找到本地 nodejs 服务器。getUser 要和 server.js 中定义的方法名一致。
            
            data: {
              //这里面是传入参数。比如我们要 select * from data where openid= 给定的 openid，就可以从这里传入
              _page:this.data.page,
              _limit:this.data.pageSize
            },
            
            success: function (res) {//成功获取到值，返回一个 res 对象。如果不知道 res 对象里面包含什么，可以先输出 res 对象看一下其中都包含什么
              console.log(res);
            },
            fail: function () {//没有获取到值，说明这中间出问题了。
              console.log("获取失败");
            },
            success: res => {
              this.setData({
                items: res.data
              });
            },
          })
    },

    onInput(event) {
      const id = event.detail.value;
      // 根据 id 查找匹配的内容，此处省略具体实现
      const match = { image: '../../static/c1.png', name: '杨俊浩' };
      this.setData({ result: match });
    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {
      if(this.data.page*this.data.pageSize>=this.data.total){
        return wx.showToast({
          title:'暂无更多人才',
          icon:'none'
        })
      }
      if  (this.data.isloading) return
this.setData({
  page:this.data.page+1
})

    },
});