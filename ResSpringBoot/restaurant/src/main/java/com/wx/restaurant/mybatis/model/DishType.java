package com.wx.restaurant.mybatis.model;

import javax.persistence.*;

@Table(name = "dish_type")
public class DishType {
    /**
     * 菜的类型主键
     */
    @Id
    @Column(name = "type_id")
    private Integer typeId;

    /**
     * 1==热销 2==新品3==锅底4==蔬菜5==肉类6==冷菜7==酒水
     */
    @Column(name = "dish_type")
    private Integer dishType;

    /**
     * 种类名字
     */
    private String name;

    /**
     * 获取菜的类型主键
     *
     * @return type_id - 菜的类型主键
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 设置菜的类型主键
     *
     * @param typeId 菜的类型主键
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
     * 获取种类名字
     *
     * @return name - 种类名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置种类名字
     *
     * @param name 种类名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}