//app.js
App({
  globalData: {
    //真是接口
    host: 'http://127.0.0.1:8088',
    //测试接口
    // host:"https://easy-mock.com/mock/5b6c4055606a404bd879c836/wxdc",
    appId: 'wx46966fd292b7eefe',
    appSecret: 'aafd006a905a36bc609aa6788c265c36',
  },
  // 登录的接口 --- 获取sessionkey和openid
  tologin: function() {
    var that = this;
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        if (res.code) {
          wx.request({
            method: "GET",
            // 以code换取 用户唯一标识openid 和 会话密钥session_key
            url: that.globalData.host + '/wxlogin/open_id/get',
            data: {
              code: res.code
            },
            success: res => {
              // console.log(res);
              wx.setStorage({
                key: 'openid',
                data: res.data.openid,
              });
              wx.setStorage({
                key: 'session_key',
                data: res.data.session_key,
              })
            }
          })
        } else {
          wx.showModal({
            title: '提示信息',
            content: '登录失败！'
          })
        }
      }
    })
  },

  onLaunch: function() {
    var that = this;
    wx.checkSession({
      success: function() {},
      fail: function() {
        that.tologin()
      }
    })
  }
})