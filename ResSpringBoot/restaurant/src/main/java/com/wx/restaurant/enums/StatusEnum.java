package com.wx.restaurant.enums;

/**
 * @param
 * @author
 * @date 2018/8/16 9:53
 */
public enum StatusEnum {
    SUCCESS(0, "SUCCESS"),
    FAIL(-1, "FAIL");
    private Integer index;
    private String value;

    StatusEnum(Integer index, String value) {
        this.index = index;
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
