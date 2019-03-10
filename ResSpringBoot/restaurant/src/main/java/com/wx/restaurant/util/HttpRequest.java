package com.wx.restaurant.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @param
 * @author Joe.Cai
 * @date 2018/6/27 9:35
 */


public  class HttpRequest {

    // ;charset=utf-8 必须要，不然会出现乱码
    /**
     * 表单数据 <br/>
     * <br/>
     * 在发送前编码所有字符（默认）<br/>
     * <br/>
     * application/x-www-form-urlencoded;charset=utf-8
     */
    public static String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded;charset=utf-8";

    /**
     * 表单数据 <br/>
     * <br/>
     * 不对字符编码。在使用包含文件上传控件的表单时，必须使用该值 <br/>
     * <br/>
     * multipart/form-data;charset=utf-8
     */
    public static String CONTENT_TYPE_FORM_DATA = "multipart/form-data;charset=utf-8";

    /**
     * text/plain;charset=utf-8
     */
    public static String CONTENT_TYPE_PLAIN = "text/plain;charset=utf-8";
    /**
     * application/json;charset=utf-8
     */
    public static String CONTENT_TYPE_JSON = "application/json;charset=utf-8";

    /**
     * @Name: post。
     * @Description: 发送post请求，并返回响应数据。
     * @Parameters: URL，要访问的url。
     * @Parameters: parms，访问参数,Map形式。
     * @Return: String，响应数据。
     */
    public static String post(String URL, Map<String, String> params) {
        StringBuilder parm = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                parm.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        return post(URL, parm.toString());
    }

    /**
     * @Name: post。
     * @Description: 发送post请求，并返回响应数据。
     * @Parameters: URL，要访问的url。
     * @Parameters: parm，访问参数。
     * @Return: String，响应数据。
     */
    public static String post(String URL, String parm) {

        HttpURLConnection conn = null;
        // 数据输出流，输出参数信息
        DataOutputStream dataOut = null;
        // 数据输入流，处理服务器响应数据
        BufferedReader dataIn = null;

        try {
            java.net.URL url = new URL(URL);

            // 将url以open方法返回的urlConnection连接强转为HttpURLConnection连接(标识一个url所引用的远程对象连接)
            // 此时cnnection只是为一个连接对象,待连接中
            conn = (HttpURLConnection) url.openConnection();

            // 设置连接输出流为true,默认false (post请求是以流的方式隐式的传递参数)
            conn.setDoOutput(true);
            // 设置连接输入流为true
            conn.setDoInput(true);
            // 设置请求方式为post
            conn.setRequestMethod("POST");
            // post请求缓存设为false
            conn.setUseCaches(false);
            // 设置该HttpURLConnection实例是否自动执行重定向
            conn.setInstanceFollowRedirects(true);

            // 设置内容的类型,设置为经过urlEncoded编码过的from参数
            conn.setRequestProperty("Content-Type", HttpRequest.CONTENT_TYPE_FORM_URLENCODED);
            conn.setRequestProperty("accept", "*/*");
            // conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;
            // MSIE 6.0; Windows NT 5.1;SV1)");

            // 建立连接
            // (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
            conn.connect();

            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            dataOut = new DataOutputStream(conn.getOutputStream());
            // 将参数输出到连接
            dataOut.writeBytes(parm != null ? parm : "");
            // 输出完成后刷新并关闭流
            dataOut.flush();

            //输出连接信息，实际使用时去掉
            outConnInfo(conn, url);

            // 连接发起请求,处理服务器响应 (从连接获取到输入流并包装为bufferedReader)
            dataIn = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            // 用来存储响应数据
            StringBuilder sb = new StringBuilder();
            // 循环读取流
            while ((line = dataIn.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 重要且易忽略步骤 (关闭流,切记!)
                if (dataOut != null) {
                    dataOut.close();
                }
                if (dataIn != null) {
                    dataIn.close();
                }
                // 销毁连接
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @Name: get。
     * @Description: 发送get请求，并返回响应数据。
     * @Parameters: URL，要访问的url。
     * @Return: String，响应数据。
     * @Author: PeiFeng
     * @Version: V1.00
     * @Create Date: 2017-8-8
     */
    public static String get(String URL) {

        HttpURLConnection conn = null;
        BufferedReader dataIn = null;

        try {
            // 把字符串转换为URL请求地址
            URL url = new URL(URL);
            // 打开连接
            conn = (HttpURLConnection) url.openConnection();
            // 连接会话
            conn.connect();
            // 获取输入流
            dataIn = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = dataIn.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 重要且易忽略步骤 (关闭流,切记!)
                if (dataIn != null) {
                    dataIn.close();
                }
                // 销毁连接
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 输出连接信息
     */
    private static void outConnInfo(HttpURLConnection conn, URL url) throws IOException {
        // url与url = conn.getURL()是等价的
        System.out.println("conn.getResponseCode():" + conn.getResponseCode());
        System.out.println("conn.getURL():" + conn.getURL());
        System.out.println("conn.getRequestMethod():" + conn.getRequestMethod());
        System.out.println("conn.getContentType():" + conn.getContentType());
        System.out.println("conn.getReadTimeout():" + conn.getReadTimeout());
        System.out.println("conn.getResponseMessage():" + conn.getResponseMessage());
        System.out.println("url.getDefaultPort():" + url.getDefaultPort());
        System.out.println("url.getFile():" + url.getFile());
        System.out.println("url.getHost():" + url.getHost());
        System.out.println("url.getPath():" + url.getPath());
        System.out.println("url.getPort():" + url.getPort());
        System.out.println("url.getProtocol():" + url.getProtocol());
        System.out.println("url.getQuery():" + url.getQuery());
        System.out.println("url.getRef():" + url.getRef());
        System.out.println("url.getUserInfo():" + url.getUserInfo());
    }
}
