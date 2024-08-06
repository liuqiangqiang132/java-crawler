package com.liuqiang.httpclients;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/4 15:44 星期日 15:44
 * @Description: 使用Httpclient进行get请求的处理！！！！！！！！！！！并添加参数进行
 * @version: 1.0
 **/
public class HttpGetPramTest {
    public static void main(String[] args)  {

        
        //请求地址:    https://yun.itheima.com/search

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //设置get请求的请求参数
            URIBuilder uriBuilder = new URIBuilder("https://yun.itheima.com/search");
            uriBuilder.setParameter("keys","java");
            //发起get请求
            CloseableHttpResponse httpResponse = httpClient.execute(new HttpGet(uriBuilder.build()));
            if (httpResponse.getStatusLine().getStatusCode()==200){
                String content = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
                System.out.println(content.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
