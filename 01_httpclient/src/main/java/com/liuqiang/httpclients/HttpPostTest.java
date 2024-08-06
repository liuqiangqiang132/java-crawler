package com.liuqiang.httpclients;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/5 10:02 星期一 10:02
 * @Description: 使用http方式post请求
 * @version: 1.0
 **/
public class HttpPostTest {
    public static void main(String[] args) {
        CloseableHttpResponse httpPostResponse = null;
        try {
             httpPostResponse = HttpClients.createDefault().execute(new HttpPost("https://www.hao123.com"));
            if (httpPostResponse.getStatusLine().getStatusCode()==200){
                String content = EntityUtils.toString(httpPostResponse.getEntity(), "utf-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
