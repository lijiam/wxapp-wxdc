package com.wx.restaurant.mybatis.mapper;

import com.wx.restaurant.mybatis.model.DishDTO;

import java.util.List;

/**
 * @param
 * @author Joe.Cai
 * @date 2018/8/12 10:46
 */
public interface DishDTOMapper {
    List<DishDTO> dishList();
}
