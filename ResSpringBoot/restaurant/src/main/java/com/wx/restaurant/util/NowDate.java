package com.wx.restaurant.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @param
 * @author Joe.Cai
 * @date 2018/6/27 9:36
 * 获取当前时间
 */

public class NowDate {
    public static String getDate() {
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = sdf.format(date);//将时间格式转换成符合Timestamp要求的格式.
        return nowTime;
    }

    /**
     * 指定日期加上天数后的日期
     *
     * @param num     为增加的天数
     * @param newDate 创建时间
     * @return
     * @throws ParseException
     */
    public static String plusDay(int num, String newDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date currDate = format.parse(newDate);
            System.out.println("现在的日期是：" + currDate);
            Calendar ca = Calendar.getInstance();
            ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
            currDate = ca.getTime();
            String endDate = format.format(currDate);
            System.out.println("增加天数以后的日期：" + endDate);
            return endDate;
        } catch (ParseException e) {
            return null;
        }
    }
}
