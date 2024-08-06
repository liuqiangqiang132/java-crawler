package com.liuqiang.httpclients;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/6 12:56 星期二 12:56
 * @Description: http的参数配置
 * @version: 1.0
 **/
public class HttpParamConfig {
    public static void main(String[] args) {


        try {
            /************************************请求参数配置***************************************/
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(10*1000)
                    .build();
            /************************************请求参数配置***************************************/
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://www.hao123.com");
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200){
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
