package com.wx.restaurant.mybatis.model;

import java.util.List;

/**
 * @param
 * @author Joe.Cai
 * @date 2018/8/12 10:42
 */
public class DishDTO {

    private Integer typeId;

    /**
     * 1==热销 2==新品3==锅底4==蔬菜5==肉类6==冷菜7==酒水
     */
    private Integer dishType;

    /**
     * 种类名字
     */
    private String name;
    /**
     * 菜
     */
    private List<Dish> foods;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getDishType() {
        return dishType;
    }

    public void setDishType(Integer dishType) {
        this.dishType = dishType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getFoods() {
        return foods;
    }

    public void setFoods(List<Dish> foods) {
        this.foods = foods;
    }
}
