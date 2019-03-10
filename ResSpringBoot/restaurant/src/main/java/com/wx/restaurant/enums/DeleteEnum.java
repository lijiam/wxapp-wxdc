package com.wx.restaurant.enums;

/**
 * @param
 * @author
 * @date 2018/8/14 9:10
 */
public enum DeleteEnum {
    HIDE(0, "隐藏"),
    DISPLAY(1, "显示");
    private Integer index;
    private String value;

    DeleteEnum(Integer index, String value) {
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
