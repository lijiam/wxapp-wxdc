package com.wx.restaurant.service;

import com.wx.restaurant.enums.DeleteEnum;
import com.wx.restaurant.enums.IntegerVarEnum;
import com.wx.restaurant.enums.ReserveStatusEnum;
import com.wx.restaurant.enums.StatusEnum;
import com.wx.restaurant.mybatis.mapper.ReserveMapper;
import com.wx.restaurant.mybatis.model.Reserve;
import com.wx.restaurant.util.NowDate;
import com.wx.restaurant.util.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @author
 * @date 2018/8/13 10:43
 */
@Service
public class ReserveService {
    @Autowired
    ReserveMapper reserveMapper;


    public Map<String, Object> reserveSave(Reserve reserve) {
        Map<String, Object> result = new HashMap<>();
        String time = NowDate.getDate();
        String diningId = RandomCode.getRandomCode();
        reserve.setCreateTime(time);
        reserve.setUpdateTime(time);
        reserve.setIsDelete(DeleteEnum.DISPLAY.getIndex());
        Integer isReserveCount = isReserve(reserve.getReserveDate(),reserve.getOpenId());
        //当天是否已经预约，目前设计每个人每天只能预约一次
        if (isReserveCount < 1) {
            Integer count = reserveList(reserve.getReserveDate(), ReserveStatusEnum.RESERVE.getIndex());
            if (count < IntegerVarEnum.MAX_RESERVE.getValue()) {
                reserve.setReserveStatus(ReserveStatusEnum.RESERVE.getIndex());
                reserve.setReserveNo(diningId);
                result.put("count", 0);
                result.put("dining_id", diningId);
                result.put("message", "预约成功");
            } else {
                count = reserveList(reserve.getReserveDate(), ReserveStatusEnum.WAIT.getIndex());
                reserve.setReserveStatus(ReserveStatusEnum.WAIT.getIndex());
                result.put("dining_id", diningId);
                result.put("count", count);
                result.put("message", "您的前面还有" + count + "人");
            }
            reserveMapper.insertSelective(reserve);
            result.put("status", StatusEnum.SUCCESS.getIndex());
        }else {
            result.put("errmsg","您已预约");
            result.put("status", StatusEnum.FAIL.getIndex());
        }
        return result;
    }

    public Integer reserveList(String date, Integer reserveStatus) {
        String str[] = date.split(" ");
        Example example = new Example(Reserve.class);
        example.createCriteria().andEqualTo("reserveStatus", reserveStatus).andLike("reserveDate", str[0] + "%");
        return reserveMapper.selectCountByExample(example);
    }
    public Integer isReserve(String date, String openId) {
        String str[] = date.split(" ");
        Example example = new Example(Reserve.class);
        example.createCriteria().andEqualTo("openId", openId).andLike("reserveDate", str[0] + "%").andBetween("reserveStatus",ReserveStatusEnum.RESERVE.getIndex(),ReserveStatusEnum.WAIT.getIndex());
        return reserveMapper.selectCountByExample(example);
    }

    public List<Reserve> myReserveList(String openId) {
        return reserveMapper.myReserveList(openId);
    }
}
