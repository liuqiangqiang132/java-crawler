package com.liuqiang.httpclients;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/6 12:36 星期二 12:36
 * @Description: 使用http连接池创建httpclient客户端请求
 * @version: 1.0
 **/
public class HttpClientTreadPoolTest01 {
    public static void main(String[] args) {
        /**
         * 1.创建连接池管理器
         * 2.发起请求
         * 3.
         */
        PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();

        //发起get请求
//        doGet(httpClientConnectionManager);
        //发起post请求
        doPost(httpClientConnectionManager);
    }

    private static void doGet(PoolingHttpClientConnectionManager httpClientConnectionManager) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(httpClientConnectionManager).build();
        try {

        CloseableHttpResponse httpGetResponse = httpClient.execute(new HttpGet("https://www.hao123.com"));
            if (httpGetResponse.getStatusLine().getStatusCode()==200){
                String contentGet = EntityUtils.toString(httpGetResponse.getEntity(), "utf-8");
                System.out.println(contentGet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    };
    private static void doPost(PoolingHttpClientConnectionManager httpClientConnectionManager) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(httpClientConnectionManager).build();
        try {

            CloseableHttpResponse httpGetResponse = httpClient.execute(new HttpPost("https://www.hao123.com"));
            if (httpGetResponse.getStatusLine().getStatusCode()==200){
                String contentGet = EntityUtils.toString(httpGetResponse.getEntity(), "utf-8");
                System.out.println(contentGet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
