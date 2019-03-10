package com.wx.restaurant.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.restaurant.mybatis.model.DishDTO;
import com.wx.restaurant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @param
 * @author
 * @date 2018/8/12 11:21
 */
@RestController
public class DishController {
    @Autowired
    DishService dishService;

    /**
     * 获取菜单列表接口
     */
    @GetMapping("/dish/list")
    public JSONArray dishList() {
        System.out.println(">>>>>>>>>>>>>>>>>调用获取菜单列表接口");
        List<DishDTO> dishDTOList = dishService.dishList();
        String str = JSONObject.toJSONString(dishDTOList);
        return JSONObject.parseArray(str);
    }
}
