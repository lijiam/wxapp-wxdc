package com.wx.restaurant.service;

import com.wx.restaurant.enums.DeleteEnum;
import com.wx.restaurant.enums.IntegerVarEnum;
import com.wx.restaurant.mybatis.mapper.CouponDTOMapper;
import com.wx.restaurant.mybatis.mapper.MyCouponMapper;
import com.wx.restaurant.mybatis.model.CouponDTO;
import com.wx.restaurant.mybatis.model.MyCoupon;
import com.wx.restaurant.util.NowDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @param
 * @author Joe.Cai
 * @date 2018/8/11 22:37
 */
@Service
public class UserService {
    @Autowired
    MyCouponMapper myCouponMapper;
    @Autowired
    CouponDTOMapper couponDTOMapper;


    public void userSave(String openid, Integer yhqid) {
        MyCoupon myCoupon = new MyCoupon();
        String time = NowDate.getDate();
        String endTime = NowDate.plusDay(IntegerVarEnum.INVALID_SEVENTH.getValue(), time);
        myCoupon.setOpenId(openid);
        myCoupon.setYhqid(yhqid);
        myCoupon.setEndTime(endTime);
        myCoupon.setCreateTime(time);
        myCoupon.setUpdateTime(time);
        myCoupon.setIsDelete(DeleteEnum.DISPLAY.getIndex());
        myCouponMapper.insertSelective(myCoupon);
    }

    public List<MyCoupon> userList(String openid, Integer yhqid) {
        Example example = new Example(MyCoupon.class);
        example.createCriteria().andEqualTo("openId", openid).andEqualTo("yhqid", yhqid);
        return myCouponMapper.selectByExample(example);
    }

    public List<CouponDTO> myCouponList(String openId) {
        return couponDTOMapper.myCouponList(openId);
    }

}
