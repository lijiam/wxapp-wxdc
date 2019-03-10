package com.wx.restaurant.enums;

/**
 * @param
 * @author
 * @date 2018/8/14 9:17
 * 0==已失效1==未付款2==已付款
 */
public enum BalanceStatusEnum {

    INVALID(0, "失效"),
    UNPAID(1, "未付款"),
    PAID(2, "已付款");

    private Integer index;
    private String value;

    BalanceStatusEnum(Integer index, String value) {
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
