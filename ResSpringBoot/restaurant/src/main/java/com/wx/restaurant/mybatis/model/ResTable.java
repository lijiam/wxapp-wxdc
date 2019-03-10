package com.wx.restaurant.mybatis.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;

@Table(name = "res_table")
public class ResTable {
    /**
     * 桌子主键
     */
    @Id
    @Column(name = "table_id")
    @JSONField(name = "table_id")
    private Integer tableId;

    @Column(name = "max_seating")
    private Integer maxSeating;

    @Column(name = "table_status")
    private Integer tableStatus;

    /**
     * 获取桌子主键
     *
     * @return table_id - 桌子主键
     */
    public Integer getTableId() {
        return tableId;
    }

    /**
     * 设置桌子主键
     *
     * @param tableId 桌子主键
     */
    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    /**
     * @return max_seating
     */
    public Integer getMaxSeating() {
        return maxSeating;
    }

    /**
     * @param maxSeating
     */
    public void setMaxSeating(Integer maxSeating) {
        this.maxSeating = maxSeating;
    }

    /**
     * @return table_status
     */
    public Integer getTableStatus() {
        return tableStatus;
    }

    /**
     * @param tableStatus
     */
    public void setTableStatus(Integer tableStatus) {
        this.tableStatus = tableStatus;
    }
}