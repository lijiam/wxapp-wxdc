package com.wx.restaurant.mybatis.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;

public class Dish {
    /**
     * 菜的主键
     */
    @Id
    @Column(name = "dish_id")
    @JSONField(name = "dish_id")
    private Integer dishId;

    /**
     * 菜名
     */
    @Column(name = "dish_name")
    @JSONField(name = "dish_name")
    private String dishName;

    /**
     * 菜的路径
     */
    @Column(name = "dish_url")
    @JSONField(name = "dish_url")
    private String dishUrl;

    /**
     * 1==不辣 2==微辣 3==中辣 4==超辣
     */
    @Column(name = "hot_status")
    @JSONField(name = "hot_status")
    private Integer hotStatus;

    /**
     * 点赞次数
     */
    @Column(name = "praise_times")
    @JSONField(name = "praise_times")
    private Integer praiseTimes;

    /**
     * 0==不是招牌 1==招牌
     */
    @Column(name = "is_sign")
    @JSONField(name = "is_sign")
    private Integer isSign;

    /**
     * 0==不是新品 1=新品
     */
    @Column(name = "is_new_dish")
    @JSONField(name = "is_new_dish")
    private Integer isNewDish;

    /**
     * 菜的销量
     */
    @Column(name = "sales_volume")
    @JSONField(name = "sales_volume")
    private Integer salesVolume;

    /**
     * 菜的价格
     */
    @Column(name = "dish_price")
    @JSONField(name = "dish_price")
    private Double dishPrice;

    /**
     * 1==热销 2==新品3==锅底4==蔬菜5==肉类6==冷菜7==酒水
     */
    @Column(name = "dish_type")
    @JSONField(name = "dish_type")
    private Integer dishType;

    /**
     * 菜的描述
     */
    @Column(name = "dish_description")
    @JSONField(name = "dish_description")
    private String dishDescription;

    /**
     * 获取菜的主键
     *
     * @return dish_id - 菜的主键
     */
    public Integer getDishId() {
        return dishId;
    }

    /**
     * 设置菜的主键
     *
     * @param dishId 菜的主键
     */
    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    /**
     * 获取菜名
     *
     * @return dish_name - 菜名
     */
    public String getDishName() {
        return dishName;
    }

    /**
     * 设置菜名
     *
     * @param dishName 菜名
     */
    public void setDishName(String dishName) {
        this.dishName = dishName == null ? null : dishName.trim();
    }

    /**
     * 获取菜的路径
     *
     * @return dish_url - 菜的路径
     */
    public String getDishUrl() {
        return dishUrl;
    }

    /**
     * 设置菜的路径
     *
     * @param dishUrl 菜的路径
     */
    public void setDishUrl(String dishUrl) {
        this.dishUrl = dishUrl == null ? null : dishUrl.trim();
    }

    /**
     * 获取1==不辣 2==微辣 3==中辣 4==超辣
     *
     * @return hot_status - 1==不辣 2==微辣 3==中辣 4==超辣
     */
    public Integer getHotStatus() {
        return hotStatus;
    }

    /**
     * 设置1==不辣 2==微辣 3==中辣 4==超辣
     *
     * @param hotStatus 1==不辣 2==微辣 3==中辣 4==超辣
     */
    public void setHotStatus(Integer hotStatus) {
        this.hotStatus = hotStatus;
    }

    /**
     * 获取点赞次数
     *
     * @return praise_times - 点赞次数
     */
    public Integer getPraiseTimes() {
        return praiseTimes;
    }

    /**
     * 设置点赞次数
     *
     * @param praiseTimes 点赞次数
     */
    public void setPraiseTimes(Integer praiseTimes) {
        this.praiseTimes = praiseTimes;
    }

    /**
     * 获取0==不是招牌 1==招牌
     *
     * @return is_sign - 0==不是招牌 1==招牌
     */
    public Integer getIsSign() {
        return isSign;
    }

    /**
     * 设置0==不是招牌 1==招牌
     *
     * @param isSign 0==不是招牌 1==招牌
     */
    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }

    /**
     * 获取0==不是新品 1=新品
     *
     * @return is_new_dish - 0==不是新品 1=新品
     */
    public Integer getIsNewDish() {
        return isNewDish;
    }

    /**
     * 设置0==不是新品 1=新品
     *
     * @param isNewDish 0==不是新品 1=新品
     */
    public void setIsNewDish(Integer isNewDish) {
        this.isNewDish = isNewDish;
    }

    /**
     * 获取菜的销量
     *
     * @return sales_volume - 菜的销量
     */
    public Integer getSalesVolume() {
        return salesVolume;
    }

    /**
     * 设置菜的销量
     *
     * @param salesVolume 菜的销量
     */
    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    /**
     * 获取菜的价格
     *
     * @return dish_price - 菜的价格
     */
    public Double getDishPrice() {
        return dishPrice;
    }

    /**
     * 设置菜的价格
     *
     * @param dishPrice 菜的价格
     */
    public void setDishPrice(Double dishPrice) {
        this.dishPrice = dishPrice;
    }

    /**
     * 获取1==热销 2==新品3==锅底4==蔬菜5==肉类6==冷菜7==酒水
     *
     * @return dish_type - 1==热销 2==新品3==锅底4==蔬菜5==肉类6==冷菜7==酒水
     */
    public Integer getDishType() {
        return dishType;
    }

    /**
     * 设置1==热销 2==新品3==锅底4==蔬菜5==肉类6==冷菜7==酒水
     *
     * @param dishType 1==热销 2==新品3==锅底4==蔬菜5==肉类6==冷菜7==酒水
     */
    public void setDishType(Integer dishType) {
        this.dishType = dishType;
    }

    /**
     * 获取菜的描述
     *
     * @return dish_description - 菜的描述
     */
    public String getDishDescription() {
        return dishDescription;
    }

    /**
     * 设置菜的描述
     *
     * @param dishDescription 菜的描述
     */
    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription == null ? null : dishDescription.trim();
    }
}