package com.wx.restaurant.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @param
 * @author Joe.Cai
 * @date 2018/6/27 9:05
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO:继承自己Mapper 该接口不能被扫描
}
