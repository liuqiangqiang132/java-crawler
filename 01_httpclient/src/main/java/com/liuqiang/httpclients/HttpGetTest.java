package com.liuqiang.httpclients;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/4 15:44 星期日 15:44
 * @Description: 使用Httpclient进行get请求的处理！！！！！！！！！！！
 * @version: 1.0
 **/
public class HttpGetTest {
    public static void main(String[] args)  {

        CloseableHttpResponse response = null;
        try {
            response = HttpClients.createDefault().execute(new HttpGet("https://www.itcast.cn"));
            if (response.getStatusLine().getStatusCode()==200){
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
