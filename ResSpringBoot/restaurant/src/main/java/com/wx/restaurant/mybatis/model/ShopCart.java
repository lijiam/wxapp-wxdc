package com.wx.restaurant.mybatis.model;

import javax.persistence.*;

@Table(name = "shop_cart")
public class ShopCart {
    /**
     * 购物车主键
     */
    @Id
    @Column(name = "shop_cart_id")
    private Integer shopCartId;

    /**
     * 订单主键
     */
    @Column(name = "balance_id")
    private Integer balanceId;

    /**
     * 菜单主键
     */
    @Column(name = "dish_id")
    private Integer dishId;

    /**
     * 菜名
     */
    private String name;

    /**
     * 单价
     */
    private Double price;

    /**
     * 备注
     */
    private String detail;

    /**
     * 购买数量
     */
    private Integer count;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 获取购物车主键
     *
     * @return shop_cart_id - 购物车主键
     */
    public Integer getShopCartId() {
        return shopCartId;
    }

    /**
     * 设置购物车主键
     *
     * @param shopCartId 购物车主键
     */
    public void setShopCartId(Integer shopCartId) {
        this.shopCartId = shopCartId;
    }

    /**
     * 获取订单主键
     *
     * @return balance_id - 订单主键
     */
    public Integer getBalanceId() {
        return balanceId;
    }

    /**
     * 设置订单主键
     *
     * @param balanceId 订单主键
     */
    public void setBalanceId(Integer balanceId) {
        this.balanceId = balanceId;
    }

    /**
     * 获取菜单主键
     *
     * @return dish_id - 菜单主键
     */
    public Integer getDishId() {
        return dishId;
    }

    /**
     * 设置菜单主键
     *
     * @param dishId 菜单主键
     */
    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    /**
     * 获取菜名
     *
     * @return name - 菜名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜名
     *
     * @param name 菜名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取单价
     *
     * @return price - 单价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price 单价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取备注
     *
     * @return detail - 备注
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置备注
     *
     * @param detail 备注
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * 获取购买数量
     *
     * @return count - 购买数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置购买数量
     *
     * @param count 购买数量
     */
    public void setCount(Integer count) {
        this.count = count;
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