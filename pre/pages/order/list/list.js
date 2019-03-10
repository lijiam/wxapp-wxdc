var app = getApp()
// pages/order/list/list.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tabIndex: 0,
    jsList: [],
    yyList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    this.queryjsList()
  },

queryjsList:function(){
  var that = this;
  wx.showLoading({
    title: '数据加载中',
  })
  wx.request({
    method: "GET",
    url: app.globalData.host + '/balance/list',
    data: {
      open_id: wx.getStorageSync("openid")
    },
    success: res => {
      // console.log(res);
      wx.hideLoading();
      that.setData({
        jsList: res.data
      })
    }
  })
},

queryyyList:function(){
  var that = this;
  wx.showLoading({
    title: '数据加载中',
  })
  wx.request({
    method: "GET",
    url: app.globalData.host + '/my/reserve/list',
    data: {
      open_id: wx.getStorageSync("openid")
    },
    success: res => {
      // console.log(res);
      wx.hideLoading();
      that.setData({
        yyList: res.data
      })
    }
  })
},

  changeTab: function(e) {
    var index = e.currentTarget.dataset.index
    this.setData({
      tabIndex: index,
    })
    if(index == 0){
      this.queryjsList();
    }else if(index ==1){
      this.queryyyList();
    }
  },
  golist: function() {
    wx.navigateTo({
      url: '../../list/list'
    })
  },
})