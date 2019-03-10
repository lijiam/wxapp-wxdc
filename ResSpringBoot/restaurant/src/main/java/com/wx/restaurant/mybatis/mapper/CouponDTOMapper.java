package com.wx.restaurant.mybatis.mapper;

import com.wx.restaurant.mybatis.model.CouponDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @param
 * @author Joe.Cai
 * @date 2018/8/13 8:55
 */
public interface CouponDTOMapper {
    List<CouponDTO> myCouponList(@Param("openId") String openId);
}
