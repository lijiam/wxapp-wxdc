Page({

  /**
   * 页面的初始数据
   */
  data: {
    userNo: '20180813001'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    wx.setNavigationBarTitle({
      title: '我的会员卡'
    });
    if (wx.getStorageSync('userNo')){
      this.setData({
        userNo: wx.getStorageSync('userNo')
      })
    }else{
      var now_time = new Date;
      var year = now_time.getFullYear();
      var month = now_time.getMonth() + 1;
      var day = now_time.getDate();
      if (month < 10) {
        month = "0" + month;
      }
      if (day < 10) {
        day = "0" + day;
      }
      var date = year + month + day;
      var no = Math.floor(Math.random() * 9000) + 1000;
      wx.setStorageSync('userNo', date.toString() + no.toString());
      this.setData({
        userNo: wx.getStorageSync('userNo')
      })
    }
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