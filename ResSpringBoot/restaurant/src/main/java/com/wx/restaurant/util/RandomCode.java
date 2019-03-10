package com.wx.restaurant.util;

import java.util.Random;

/**
 * @param
 * @author Joe.Cai
 * @date 2018/7/13 14:16
 */
public class RandomCode {
    public static String getRandomCode(){
        StringBuffer flag = new StringBuffer();
        String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
        Random rand = new Random();
        for (int j = 0; j < 3; j++)
        {
            flag.append(sources.charAt(rand.nextInt(9)) + "");
        }
        System.out.println(flag.toString());
        return flag.toString();
    }
    public static String getRandomOpenCode(){
        StringBuffer flag = new StringBuffer();
        String sources = "0123456789abcdefghijklmnopqrestuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 加上一些字母，就可以生成pc站的验证码了
        Random rand = new Random();
        for (int j = 0; j < 27; j++)
        {
            flag.append(sources.charAt(rand.nextInt(61)) + "");
        }
        System.out.println(flag.toString());
        return flag.toString();
    }
}
