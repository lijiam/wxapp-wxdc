package com.wx.restaurant.enums;

/**
 * @param
 * @author
 * @date 2018/8/15 10:03
 * 基本常量
 */
public enum IntegerVarEnum {

    MAX_RESERVE(2),
    INVALID_SEVENTH(7);
    private Integer value;

    IntegerVarEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
