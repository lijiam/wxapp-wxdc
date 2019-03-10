package com.wx.restaurant.mybatis.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;

public class Balance {
    /**
     * 订单主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JSONField(name = "order_id")
    private Integer id;

    /**
     * 0==删除 1==显示
     */
    @Column(name = "is_delete")
    @JSONField(name = "is_delete")
    private Integer isDelete;

    /**
     * 1==未付款2==已付款3==已失效
     */
    @Column(name = "balance_status")
    @JSONField(name = "balance_status")
    private Integer balanceStatus;

    /**
     * 订单总价
     */
    @Column(name = "total_price")
    @JSONField(name = "total_price")
    private Double totalPrice;

    /**
     * 小程序openid
     */
    @Column(name = "open_id")
    @JSONField(name = "open_id")
    private String openId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JSONField(name = "create_time")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @JSONField(name = "update_time")
    private String updateTime;

    /**
     * 获取订单主键
     *
     * @return id - 订单主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单主键
     *
     * @param id 订单主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取0==删除 1==显示
     *
     * @return is_delete - 0==删除 1==显示
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置0==删除 1==显示
     *
     * @param isDelete 0==删除 1==显示
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取1==未付款2==已付款3==已失效
     *
     * @return balance_status - 1==未付款2==已付款3==已失效
     */
    public Integer getBalanceStatus() {
        return balanceStatus;
    }

    /**
     * 设置1==未付款2==已付款3==已失效
     *
     * @param balanceStatus 1==未付款2==已付款3==已失效
     */
    public void setBalanceStatus(Integer balanceStatus) {
        this.balanceStatus = balanceStatus;
    }

    /**
     * 获取订单总价
     *
     * @return total_price - 订单总价
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置订单总价
     *
     * @param totalPrice 订单总价
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取小程序openid
     *
     * @return open_id - 小程序openid
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置小程序openid
     *
     * @param openId 小程序openid
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}