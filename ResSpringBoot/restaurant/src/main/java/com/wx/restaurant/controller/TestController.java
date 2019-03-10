package com.wx.restaurant.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.restaurant.mybatis.model.Balance;
import com.wx.restaurant.mybatis.model.DishDTO;
import com.wx.restaurant.mybatis.model.ShopCart;
import com.wx.restaurant.service.BalanceService;
import com.wx.restaurant.service.DishService;
import com.wx.restaurant.service.ResTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @author
 * @date 2018/8/11 17:41
 *
 * TODO:测试接口 等项目完成后删掉
 */
@RestController
public class TestController {

    @Autowired
    ResTableService resTableService;
    @Autowired
    DishService dishService;
    @Autowired
    BalanceService balanceService;

    @GetMapping("/test/table/get")
    public JSONObject getTable() {
        String str = JSONObject.toJSONString(resTableService.getTable());
        return JSONObject.parseObject(str);
    }

    @GetMapping("/test/dish/list")
    public JSONArray dishList() {
        List<DishDTO> dishDTOList = dishService.dishList();
        String str =  JSONObject.toJSONString(dishDTOList);
        return JSONObject.parseArray(str);
    }

    @PostMapping("/test/balance/insert")
    public Map<String,Object> balanceSave(@RequestBody JSONObject data){
        Map<String,Object> map = new HashMap<>();
        Balance balance = new Balance();
        balance.setOpenId(data.getString("open_id"));
        balance.setTotalPrice(data.getDouble("total_price"));
        String str = data.getJSONArray("cartList").toJSONString();
        List<ShopCart> shopList = JSONObject.parseArray(str,ShopCart.class);
        balanceService.balanceSave(balance,shopList);
        map.put("data",balance);
        return map;
    }
}
