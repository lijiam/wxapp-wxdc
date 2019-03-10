package com.wx.restaurant.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.restaurant.enums.ReserveStatusEnum;
import com.wx.restaurant.enums.StatusEnum;
import com.wx.restaurant.mybatis.model.Reserve;
import com.wx.restaurant.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @param
 * @author
 * @date 2018/8/13 9:49
 */
@RestController
@RequestMapping("/reserve")
public class ReserveController {
    @Autowired
    ReserveService reserveService;

    /**
     * 用户预约接口
     *
     * @param data 小程序 openId 预约时间 reserveDate
     */
    @PostMapping("/insert")
    public Map<String, Object> reserveSave(@RequestBody JSONObject data) {
        System.out.println(">>>>>>>>>>>>>>>调用用户预约接口");
        String str = JSONObject.toJSONString(data);
        Reserve reserve = JSONObject.parseObject(str, Reserve.class);
        return reserveService.reserveSave(reserve);
    }

    /**
     * 用户预约需等待人数接口
     *
     * @param reserveDate 预约时间
     */
    @GetMapping("/wait/count")
    public Map<String, Object> waitCount(@RequestParam("reserve_date") String reserveDate) {
        System.out.println(">>>>>>>>>>>>>>调用用户预约需等待人数接口");
        Map<String, Object> result = new HashMap<>();
        Integer count = reserveService.reserveList(reserveDate, ReserveStatusEnum.WAIT.getIndex());
        result.put("count", count);
        result.put("status", StatusEnum.SUCCESS.getIndex());
        return result;
    }

}
