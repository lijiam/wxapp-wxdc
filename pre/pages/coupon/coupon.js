var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    couponList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    wx.setNavigationBarTitle({
      title: '我的优惠券'
    })
    var that = this;
    wx.showLoading({
      title: '查询中',
    })
    wx.request({
      method: "GET",
      url: app.globalData.host + '/my/coupon/list',
      data: {
        open_id: wx.getStorageSync('openid')
      },
      success: res => {
        wx.hideLoading();
        console.log(res);
        that.setData({
          couponList: res.data
        })
      }
    })
  },

  gotouse: function() {
    wx.navigateTo({
      url: '../list/list',
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