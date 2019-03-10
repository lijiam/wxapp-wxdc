package com.wx.restaurant.mybatis.model;

import javax.persistence.*;

public class Coupon {
    /**
     * 优惠券主键
     */
    @Id
    private Integer yhqid;

    /**
     * 图片url
     */
    private String imgurl;

    /**
     * 金额
     */
    private Integer je;

    /**
     * 满足金额
     */
    private Integer mzje;

    /**
     * 满足条件
     */
    private String mztj;

    /**
     * 获取优惠券主键
     *
     * @return yhqid - 优惠券主键
     */
    public Integer getYhqid() {
        return yhqid;
    }

    /**
     * 设置优惠券主键
     *
     * @param yhqid 优惠券主键
     */
    public void setYhqid(Integer yhqid) {
        this.yhqid = yhqid;
    }

    /**
     * 获取图片url
     *
     * @return imgurl - 图片url
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * 设置图片url
     *
     * @param imgurl 图片url
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    /**
     * 获取金额
     *
     * @return je - 金额
     */
    public Integer getJe() {
        return je;
    }

    /**
     * 设置金额
     *
     * @param je 金额
     */
    public void setJe(Integer je) {
        this.je = je;
    }

    /**
     * 获取满足金额
     *
     * @return mzje - 满足金额
     */
    public Integer getMzje() {
        return mzje;
    }

    /**
     * 设置满足金额
     *
     * @param mzje 满足金额
     */
    public void setMzje(Integer mzje) {
        this.mzje = mzje;
    }

    /**
     * 获取满足条件
     *
     * @return mztj - 满足条件
     */
    public String getMztj() {
        return mztj;
    }

    /**
     * 设置满足条件
     *
     * @param mztj 满足条件
     */
    public void setMztj(String mztj) {
        this.mztj = mztj == null ? null : mztj.trim();
    }
}