package com.wx.restaurant.mybatis.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;

public class Reserve {
    /**
     * 预约主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 小程序openId
     */
    @Column(name = "open_id")
    @JSONField(name = "open_id")
    private String openId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    @JSONField(name = "user_id")
    private Integer userId;

    /**
     * 桌子id
     */
    @Column(name = "table_id")
    @JSONField(name = "table_id")
    private Integer tableId;

    /**
     * 预约号码
     */
    @Column(name = "reserve_no")
    @JSONField(name = "reserve_no")
    private String reserveNo;

    /**
     * 0==失效 1==预约 2== 等待 3==无法预约
     */
    @Column(name = "reserve_status")
    @JSONField(name = "reserve_status")
    private Integer reserveStatus;

    /**
     * 预约时间
     */
    @Column(name = "reserve_date")
    @JSONField(name = "reserve_date")
    private String reserveDate;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JSONField(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @JSONField(name = "update_time")
    private String updateTime;

    /**
     * 0==删除  1==显示
     */
    @Column(name = "is_delete")
    @JSONField(name = "is_delete")
    private Integer isDelete;

    /**
     * 获取预约主键
     *
     * @return id - 预约主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置预约主键
     *
     * @param id 预约主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取小程序openId
     *
     * @return open_id - 小程序openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置小程序openId
     *
     * @param openId 小程序openId
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取桌子id
     *
     * @return table_id - 桌子id
     */
    public Integer getTableId() {
        return tableId;
    }

    /**
     * 设置桌子id
     *
     * @param tableId 桌子id
     */
    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    /**
     * 获取预约号码
     *
     * @return reserve_no - 预约号码
     */
    public String getReserveNo() {
        return reserveNo;
    }

    /**
     * 设置预约号码
     *
     * @param reserveNo 预约号码
     */
    public void setReserveNo(String reserveNo) {
        this.reserveNo = reserveNo == null ? null : reserveNo.trim();
    }

    /**
     * 获取0==失效 1==预约 2== 等待 3==无法预约
     *
     * @return reserve_status - 0==失效 1==预约 2== 等待 3==无法预约
     */
    public Integer getReserveStatus() {
        return reserveStatus;
    }

    /**
     * 设置0==失效 1==预约 2== 等待 3==无法预约
     *
     * @param reserveStatus 0==失效 1==预约 2== 等待 3==无法预约
     */
    public void setReserveStatus(Integer reserveStatus) {
        this.reserveStatus = reserveStatus;
    }

    /**
     * 获取预约时间
     *
     * @return reserve_date - 预约时间
     */
    public String getReserveDate() {
        return reserveDate;
    }

    /**
     * 设置预约时间
     *
     * @param reserveDate 预约时间
     */
    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate == null ? null : reserveDate.trim();
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * 获取0==删除  1==显示
     *
     * @return is_delete - 0==删除  1==显示
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置0==删除  1==显示
     *
     * @param isDelete 0==删除  1==显示
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}