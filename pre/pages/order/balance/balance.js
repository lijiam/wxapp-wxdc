var app = getApp();

// pages/order/balance/balance.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    cartList: [],
    sumMonney: 0,
    cutMonney: 0,
    beizhu: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    wx.setNavigationBarTitle({
      title: '订单详情'
    })
    this.setData({
      cartList: wx.getStorageSync('cartList'),
      sumMonney: wx.getStorageSync('sumMonney'),
      cutMonney: wx.getStorageSync('sumMonney') > 149 ? 10 : 0
    })

  },

  bindblur: function(e) {
    this.data.beizhu = e.detail.value;
  },

  bindconfirm:function(e){
    this.data.beizhu = e.detail.value;
  },

  gopay: function() {
    wx.showModal({
      title: '温馨提示',
      content: '模拟微信支付，权限问题无法开放。',
      confirmColor: '#B6D9A9',
      cancelColor: '#DC143C',
      success: res => {
        if (res.confirm) {
          wx.request({
            method: "GET",
            url: app.globalData.host + '/balance/update',
            data: {
              order_id: wx.getStorageSync("order_id")
            },
            success: res => {
              if (res.data.status == "0") {
                wx.setStorageSync("dining_id", res.data.dining_id);
                wx.showToast({
                  title: '支付成功',
                  image:'../../../images/icon-success.png'
                })
                wx.navigateTo({
                  url: '../detail/detail?dining_id=' + res.data.dining_id
                })
              }else if(res.data.status == "-1"){
                wx.showToast({
                  title: res.data.errmsg,
                  image: '../../../images/icon-err.png'
                })
              }
            }
          })
        }else if(res.cancel){
          wx.showToast({
            title: '取消支付',
            image: '../../../images/icon-err.png'
          })
        }
      }
    })


    
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})