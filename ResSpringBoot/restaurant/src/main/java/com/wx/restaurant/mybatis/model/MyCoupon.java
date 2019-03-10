package com.wx.restaurant.mybatis.model;

import javax.persistence.*;

@Table(name = "my_coupon")
public class MyCoupon {
    /**
     * 用户主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 小程序openid
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 用户昵称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 优惠券id
     */
    private Integer yhqid;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 失效时间
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 0==删除 1==显示
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 获取用户主键
     *
     * @return id - 用户主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户主键
     *
     * @param id 用户主键
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取用户昵称
     *
     * @return user_name - 用户昵称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户昵称
     *
     * @param userName 用户昵称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取优惠券id
     *
     * @return yhqid - 优惠券id
     */
    public Integer getYhqid() {
        return yhqid;
    }

    /**
     * 设置优惠券id
     *
     * @param yhqid 优惠券id
     */
    public void setYhqid(Integer yhqid) {
        this.yhqid = yhqid;
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
     * 获取失效时间
     *
     * @return end_time - 失效时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置失效时间
     *
     * @param endTime 失效时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
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
}