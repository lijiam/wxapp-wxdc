package com.wx.restaurant.service;

/**
 * @param
 * @author
 * @date 2018/8/12 10:54
 */
import com.wx.restaurant.mybatis.mapper.DishDTOMapper;
import com.wx.restaurant.mybatis.model.DishDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    @Autowired
    DishDTOMapper dishDTOMapper;

    public List<DishDTO> dishList(){
        return dishDTOMapper.dishList();
    }

}