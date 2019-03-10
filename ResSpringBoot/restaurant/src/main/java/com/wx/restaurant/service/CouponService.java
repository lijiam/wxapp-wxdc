package com.wx.restaurant.service;

import com.wx.restaurant.mybatis.mapper.CouponMapper;
import com.wx.restaurant.mybatis.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @param
 * @author
 * @date 2018/8/11 21:53
 */
@Service
public class CouponService {
    @Autowired
    CouponMapper couponMapper;

    public List<Coupon> couponList(){
        return couponMapper.selectAll();
    }


}
