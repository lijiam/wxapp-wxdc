package com.wx.restaurant.controller;

import com.wx.restaurant.mybatis.model.CouponDTO;
import com.wx.restaurant.mybatis.model.Reserve;
import com.wx.restaurant.service.ReserveService;
import com.wx.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @param
 * @author
 * @date 2018/8/13 8:50
 */
@RestController
@RequestMapping("/my")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ReserveService reserveService;

    /**
     * 获取个人优惠券列表接口
     *
     * @param openId 小程序openId
     */

    @GetMapping("/coupon/list")
    public List<CouponDTO> couponList(@RequestParam("open_id") String openId) {
        System.out.println(">>>>>>>>>>>>>>>>>>调用获取个人优惠券列表接口");
        return userService.myCouponList(openId);
    }

    /**
     * 获取个人预约列表接口
     *
     * @param openId 小程序openId
     * @return
     */
    @GetMapping("/reserve/list")
    public List<Reserve> reserveList(@RequestParam("open_id") String openId) {
        System.out.println(">>>>>>>>>>>>>>>>>>>调用获取个人预约列表接口");
        return reserveService.myReserveList(openId);
    }

}
