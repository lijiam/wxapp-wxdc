package com.wx.restaurant.mybatis.mapper;

import com.wx.restaurant.mybatis.model.Reserve;
import com.wx.restaurant.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReserveMapper extends MyMapper<Reserve> {
    @Select("SELECT * from reserve  where open_id =#{openId} and reserve_status BETWEEN 1 and 2 ORDER BY create_time desc")
    List<Reserve> myReserveList(@Param("openId") String openId);

}