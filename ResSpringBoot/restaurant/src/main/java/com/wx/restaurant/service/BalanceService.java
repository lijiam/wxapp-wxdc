package com.wx.restaurant.service;

import com.wx.restaurant.enums.BalanceStatusEnum;
import com.wx.restaurant.enums.DeleteEnum;
import com.wx.restaurant.mybatis.mapper.BalanceMapper;
import com.wx.restaurant.mybatis.mapper.ShopCartMapper;
import com.wx.restaurant.mybatis.model.Balance;
import com.wx.restaurant.mybatis.model.ShopCart;
import com.wx.restaurant.util.NowDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param
 * @author
 * @date 2018/8/12 16:55
 */
@Service
public class BalanceService {
    @Autowired
    BalanceMapper balanceMapper;
    @Autowired
    ShopCartMapper shopCartMapper;

    public void balanceSave(Balance balance, List<ShopCart> shopCartList) {
        String time = NowDate.getDate();
        balance.setCreateTime(time);
        balance.setUpdateTime(time);
        balance.setBalanceStatus(BalanceStatusEnum.UNPAID.getIndex());
        balance.setIsDelete(DeleteEnum.DISPLAY.getIndex());
        balanceMapper.insertUseGeneratedKeys(balance);
        Integer balanceId = balance.getId();
        for (ShopCart shopCart : shopCartList) {
            shopCart.setBalanceId(balanceId);
            shopCart.setCreateTime(time);
            shopCart.setUpdateTime(time);
        }
        shopCartMapper.insertList(shopCartList);
    }

    public void balanceUpdate(Integer balanceId) {
        Balance balance = new Balance();
        String time = NowDate.getDate();
        balance.setId(balanceId);
        balance.setBalanceStatus(BalanceStatusEnum.PAID.getIndex());
        balance.setUpdateTime(time);
        balanceMapper.updateByPrimaryKeySelective(balance);
        shopCartMapper.salesVolumeAdd(balanceId);
    }

    public List<Balance> balanceList(String openId) {
        return balanceMapper.balanceList(openId);
    }
}
