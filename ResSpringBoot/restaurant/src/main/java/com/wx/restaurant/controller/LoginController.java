package com.wx.restaurant.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.wx.restaurant.enums.StatusEnum;
import com.wx.restaurant.util.HttpRequest;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;

/**
 * @param
 * @author
 * @date 2018/8/10 15:31
 */
@Controller
@ResponseBody
@RequestMapping("/wxlogin")
public class LoginController {
    @Value(value = "${appid}")
    String appid;
    @Value(value = "${secret}")
    String secret;
    @Value(value = "${grant_type}")
    String grant_type;

    /**
     * 获取小程序openid
     *
     * @param code 小程序code换取openid和sessionKey
     */
    @GetMapping("/open_id/get")
    public Object getOpenId(@RequestParam("code") String code) {
        System.out.println(">>>>>>>>>>>>>>调用获取小程序openid接口");
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=" + grant_type;
        System.out.println(url);
        String data = HttpRequest.get(url);
        return JSON.parse(data);
    }

    /**
     * 小程序授权手机号解密   此接口本项目展示没用
     *
     * @param encrypdata
     * @param ivdata
     * @param sessionkey
     */
    @GetMapping("/user_phone/get")
    public JSONObject getUserPhone(@RequestParam("encrypdata") String encrypdata,
                                   @RequestParam("ivdata") String ivdata,
                                   @RequestParam("sessionkey") String sessionkey) {
        JSONObject result = new JSONObject();
        byte[] encrypData = Base64.decode(encrypdata);
        byte[] ivData = Base64.decode(ivdata);
        byte[] sessionKey = Base64.decode(sessionkey);
        String str = "";
        try {
            str = decrypt(sessionKey, ivData, encrypData);
            result.put("data", str);
            result.put("status", StatusEnum.SUCCESS.getIndex());
        } catch (Exception e) {
            result.put("errmsg", e);
            result.put("status", StatusEnum.FAIL.getIndex());
        }
        System.out.println(str);
        return result;

    }

    /**
     * 解密后的手机号
     *
     * @param key
     * @param iv
     * @param encData
     * @return
     * @throws Exception
     */
    private static String decrypt(byte[] key, byte[] iv, byte[] encData) throws Exception {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        //解析解密后的字符串
        return new String(cipher.doFinal(encData), "UTF-8");
    }
}
