package com.wx.restaurant.service;


import com.wx.restaurant.mybatis.mapper.ResTableMapper;

import com.wx.restaurant.mybatis.model.ResTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @param
 * @author
 * @date 2018/8/11 10:49
 */
@Service
public class ResTableService {

    @Autowired
    ResTableMapper resTableMapper;

    public ResTable getTable(){
        Example example = new Example(ResTable.class);
        example.createCriteria().andEqualTo("tableId",1);
        return resTableMapper.selectByExample(example).get(0);
    }
}
