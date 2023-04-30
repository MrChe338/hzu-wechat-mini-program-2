// components/xmxq/xmxq.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    item:{
      type:Object,
      value:{
        1:"测试标题"
      }
    },
  },

  /**
   * 组件的初始数据
   */
  data: {
    tagsarr:[],
    
  },

  /**
   * 组件的方法列表
   */
  methods: {
    renderTags() {
      let tags = this.properties.item.tags.split(',');
      this.setData({
        tagsarr: tags,
      });
      console.log(tags);
    },
  },
   // 生命周期函数（生命周期函数）

   attached: function () {
    // 在生命周期中调用渲染标签的方法
    this.renderTags();
  },
})
