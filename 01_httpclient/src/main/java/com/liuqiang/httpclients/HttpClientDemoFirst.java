package com.liuqiang.httpclients;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/4 11:38 星期日 11:38
 * @Description: 有关httpClient的第一个案例程序
 * @version: 1.0
 **/
public class HttpClientDemoFirst {
    public static void main(String[] args) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.itcast.cn");
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode()==200){
                HttpEntity entity = httpResponse.getEntity();
                String content = EntityUtils.toString(entity, "utf-8");
                //获取到的响应结果
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
