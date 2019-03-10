var app = getApp();
// pages/mine/mine.js
Page({
  /**
   * 页面的初始数据
   */
  data: {
    showUser: true,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    nickName: "用户昵称",
    avatarUrl: "https://lg-7s6viuzs-1256301647.cos.ap-shanghai.myqcloud.com/touxiang.png",
    phoneNumber: '10086'
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function() {
    var that = this;
    // 查看是否授权
    wx.getSetting({
      success: function(res) {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称
          wx.getUserInfo({
            success: function(res) {
              that.setData({
                showUser: false,
                nickName: res.userInfo.nickName,
                avatarUrl: res.userInfo.avatarUrl
              })
              wx.setStorage({
                key: 'userInfo',
                data: res.userInfo
              })
            }
          })
        }
      }
    })
  },
  // 授权的登录的接口
  bindGetUserInfo: function(e) {
    var that = this;
    if (!this.data.canIUse) {
      wx.showModal({
        title: '提示信息',
        content: '您的微信版本过低，请升级后尝试。',
      })
    } else {
      var userInfo = e.detail.userInfo;
      that.setData({
        showUser: false,
        nickName: userInfo.nickName,
        avatarUrl: userInfo.avatarUrl
      });
      wx.setStorage({
        key: 'userInfo',
        data: userInfo
      })
    }
  },
  // 拨打电话的接口
  bitphone: function() {
    wx.makePhoneCall({
      phoneNumber: '10086',
      success: function() {}
    })
  },
  // 展示我的优惠券
  showMyYhqs: function() {
    wx.navigateTo({
      url: '../coupon/coupon',
    })
  },
  //展示我的会员卡
  showMyCard: function() {
    wx.navigateTo({
      url: '../usercard/usercard',
    })
  }
})