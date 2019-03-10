package com.wx.restaurant.mybatis.mapper;

import com.wx.restaurant.mybatis.model.Balance;
import com.wx.restaurant.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BalanceMapper extends MyMapper<Balance> {
    @Select("select * from balance where open_id =#{openId} and balance_status between 0 and 1 and is_delete = 1 order by update_time desc")
    List<Balance>balanceList(@Param("openId") String openId);
}