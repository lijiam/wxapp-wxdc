package com.wx.restaurant.enums;

/**
 * @param
 * @author
 * @date 2018/8/14 9:02
 * 0==失效 1==预约 2== 等待 3==无法预约
 */
public enum ReserveStatusEnum {
    INVALID(0, "失效"),
    RESERVE(1, "预约"),
    WAIT(2, "等待"),
    UNABLE_RESERVE(3, "无法预约");

    ReserveStatusEnum(Integer index, String value) {
        this.index = index;
        this.value = value;
    }

    private Integer index;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
