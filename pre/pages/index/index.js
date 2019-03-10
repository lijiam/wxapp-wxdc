//index.js
var util = require('../../utils/util.js')
//获取应用实例
const app = getApp()

Page({
  data: {
    nowtime: util.formatTime(new Date()),
    //轮播图
    imgUrls: [
      '../../images/lb_01.gif',
      '../../images/lb_02.gif',
      '../../images/lb_03.gif'
    ],
    indicatorDots: true,
    autoplay: true,
    interval: 3000,
    indicatorActiveColor: "#DC143C",
    //模态框
    item: {
      index: 0,
      msg: 'this is a template',
      time: '2016-09-15'
    },
    bottomImgs: []
  },
  onLoad: function() {
    var that = this;
    wx.showLoading({
      title: '数据加载中',
    })
    wx.request({
      method: "GET",
      url: app.globalData.host + '/index/coupon/list',
      data: {},
      success: res => {
        // console.log(res);
        that.setData({
          bottomImgs: res.data
        })
        wx.hideLoading()
      }
    })
  },
// 我要点餐
  golist: function() {
    wx.navigateTo({
      url: '../list/list'
    })
  },
  // 我要预定
  goreserve:function(){
    var count = 0;
    var that = this;
    wx.request({
      method: "GET",
      url: app.globalData.host + '/reserve/wait/count',
      data: {
        reserve_date: that.data.nowtime
      },
      success: res => {
        count = res.data.count;
        wx.showModal({
          title: '温馨提示',
          content: '您之前还有'+count+'位顾客正在等待就餐，您确定需要预定吗？',
          confirmColor: '#B6D9A9',
          cancelColor: '#DC143C',
          success:res=>{
            if(res.confirm){
              wx.request({
                method: "POST",
                url: app.globalData.host +'/reserve/insert',
                data: {
                  open_id: wx.getStorageSync('openid'),
                  reserve_date:that.data.nowtime
                },
                success:e=>{
                  console.log(e);
                  if (e.data.status == "0") {
                    wx.navigateTo({
                      url: '../reserve/reserve?diningId=' + e.data.dining_id + '&preNo=' + count,
                    })
                  } else {
                    wx.showToast({
                      title: '桌位已满',
                      image: '../../images/icon-err.png',
                      mask: true
                    })
                  }
                }
              })
            }
          }
        })
      }
    })
  },
  // 获取优惠券
  insertYhq: function(e) {
    var yhqid = e.currentTarget.dataset.item.yhqid;
    var je = e.currentTarget.dataset.item.je;
    wx.showModal({
      title: '温馨提示',
      content: '您确定要领取'+je+'元优惠券？',
      confirmColor:'#B6D9A9',
      cancelColor:'#DC143C',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            method: "GET",
            url: app.globalData.host + '/index/coupon/receive',
            data: {
              openid: wx.getStorageSync('openid'),
              yhqid:yhqid
            },
            success: res => {
              // console.log(res);
              if (res.data.status == "0") {
                wx.showToast({
                  title: '领取成功',
                  image: '../../images/icon-success.png',
                  mask: true
                })
              } else {
                wx.showToast({
                  title: '已达上限',
                  image: '../../images/icon-err.png',
                  mask: true
                })
              }
            }
          })
        } else if (res.cancel) {
          // console.log('用户点击取消');
        }
      }
    })
  }
})