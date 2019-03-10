const app = getApp();
// pages/list/list.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    listData: [],
    activeIndex: 0,
    toView: 'a0',
    scrollTop: 100,
    screenWidth: 667,
    showModalStatus: false,
    cartList: [],
    sumMonney: 0,
    showCart: false,
    loading: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    // var sysinfo = wx.getSystemInfoSync().windowHeight;
    // console.log(sysinfo)
    wx.showLoading({
      title: '数据加载中',
    })
    //将本来的后台换成了easy-mock 的接口，所有数据一次请求完 略大。。
    wx.request({
      url: app.globalData.host + '/dish/list',
      method: 'GET',
      data: {},
      header: {
        'Accept': 'application/json'
      },
      success: function(res) {
        wx.hideLoading();
        // console.log(res);
        that.setData({
          listData: res.data,
          loading: true
        })
      }
    })
  },
  selectMenu: function(e) {
    var index = e.currentTarget.dataset.index
    // console.log(index)
    this.setData({
      activeIndex: index,
      toView: 'a' + index,
    })
    console.log(this.data.toView);
  },
  scroll: function(e) {
    var dis = e.detail.scrollTop;
    // console.log(dis);
    if (dis > 0 && dis < 385) {
      this.setData({
        activeIndex: 0,
      })
    }
    if (dis > 385 && dis < 772) {
      this.setData({
        activeIndex: 1,
      })
    }
    if (dis > 772 && dis < 1157) {
      this.setData({
        activeIndex: 2,
      })
    }
    if (dis > 1157 && dis < 2273) {
      this.setData({
        activeIndex: 3,
      })
    }
    if (dis > 2273 && dis < 3389) {
      this.setData({
        activeIndex: 4,
      })
    }
    if (dis > 3389 && dis < 3775) {
      this.setData({
        activeIndex: 5,
      })
    }
    if (dis > 3775) {
      this.setData({
        activeIndex: 6,
      })
    }
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  selectInfo: function(e) {
    // console.log(e);
    var type = e.currentTarget.dataset.type;
    var index = e.currentTarget.dataset.index;
    this.setData({
      showModalStatus: !this.data.showModalStatus
    });
  },

  addToCart: function(e) {
    var isHave = false;
    var a = this.data;
    var cartList = this.data.cartList;
    var t = e.currentTarget.dataset.type;
    var i = e.currentTarget.dataset.index;
    var addItem = {};
    if (cartList.length) {
      try {
        cartList.forEach(function(item) {
          if (item.dish_id == a.listData[t].foods[i].dish_id) {
            item.count += 1;
            isHave = true;
            throw new Error("break foreach");
          }
        })
      } catch (e) {
        if (e.message != 'break foreach') {
          console.log(e);
        }
      }
      if (!isHave) {
        addItem = {
          "dish_id": a.listData[t].foods[i].dish_id,
          "name": a.listData[t].foods[i].dish_name,
          "price": a.listData[t].foods[i].dish_price,
          "detail": a.listData[t].foods[i].dish_description,
          "count": 1
        }
        cartList.push(addItem);
      }
    } else {
      addItem = {
        "dish_id": a.listData[t].foods[i].dish_id,
        "name": a.listData[t].foods[i].dish_name,
        "price": a.listData[t].foods[i].dish_price,
        "detail": a.listData[t].foods[i].dish_description,
        "count": 1
      }
      cartList.push(addItem);
    }
    var sumMonney = a.sumMonney + a.listData[t].foods[i].dish_price;
    this.setData({
      cartList: cartList,
      showModalStatus: false,
      sumMonney: sumMonney
    });
    // console.log(this.data.cartList)
  },
  showCartList: function() {
    // console.log(this.data.showCart)
    if (this.data.cartList.length != 0) {
      this.setData({
        showCart: !this.data.showCart,
      });
    }
  },

  clearCartList: function() {
    this.setData({
      cartList: [],
      showCart: false,
      sumMonney: 0
    });
  },

  addNumber: function(e) {
    var index = e.currentTarget.dataset.index;
    var cartList = this.data.cartList;
    cartList[index].count++;
    var sum = this.data.sumMonney + cartList[index].price;
    this.setData({
      cartList: cartList,
      sumMonney: sum
    });
  },
  decNumber: function(e) {
    var index = e.currentTarget.dataset.index;
    var cartList = this.data.cartList;
    var sum = this.data.sumMonney - cartList[index].price;
    cartList[index].count == 1 ? cartList.splice(index, 1) : cartList[index].count--;
    this.setData({
      cartList: cartList,
      sumMonney: sum,
      showCart: cartList.length == 0 ? false : true
    });
  },
  goBalance: function() {
    var that=  this;
    wx.showModal({
      title: '温馨提示',
      content: '下单后将不可修改订单，确认下单？',
      confirmColor: '#B6D9A9',
      cancelColor: '#DC143C',
      success:res=>{
        if(res.confirm){
          wx.request({
            method:"POST",
            url: app.globalData.host +'/balance/insert',
            data:{
              cartList: that.data.cartList,
              open_id:wx.getStorageSync("openid"),
              total_price: that.data.sumMonney
            },
            success:res=>{
              if(res.data.status == "0"){
                wx.setStorageSync("order_id", res.data.order_id);
                if (this.data.sumMonney != 0) {
                  wx.setStorageSync('cartList', that.data.cartList);
                  wx.setStorageSync('sumMonney', that.data.sumMonney);
                  wx.navigateTo({
                    url: '../order/balance/balance'
                  })
                }
              }else if(res.data.status == "-1"){
                wx.showToast({
                  title: res.data.errmsg,
                  image:'../../images/icon-err.png'
                })
              }
            }
          })
        }
      }
    })
  },

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