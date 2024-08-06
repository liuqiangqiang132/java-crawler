package com.liuqiang.httpclients;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/5 10:02 星期一 10:02
 * @Description: 使用http方式post请求
 * @version: 1.0
 **/
public class HttpPostParamTest {
    public static void main(String[] args) {

        try {
            CloseableHttpClient httpPostClient = HttpClients.createDefault();
            //设置携带参数的post请求
            HttpPost httpPost = new HttpPost("https://yun.itheima.com/search");
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("keys","Java"));
            //设置entity
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params,"utf-8");
            httpPost.setEntity(urlEncodedFormEntity);
            //发起post请求
            CloseableHttpResponse httpResponse = httpPostClient.execute(httpPost);

            if (httpResponse.getStatusLine().getStatusCode()==200){
                String content = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
