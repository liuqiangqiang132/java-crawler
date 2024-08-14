package com.liuqiang.jd.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/8 14:15 星期四 14:15
 * @Description: httpClient的封装的工具类
 * @version: 1.0
 **/
@Component
public class httpClientUtils {


    private final PoolingHttpClientConnectionManager connectionManager;

    public httpClientUtils() {
        connectionManager = new PoolingHttpClientConnectionManager();
        //设置连接池的基本配置信息
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(100);
    }

    /**
     * 下载网页
     * @param url 网站地址
     * @return 解析后的网站地址
     */
    public String doGetHtml(String url){

        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        try {

            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(this.getRequestConfig());
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode()==200){
                String html = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
                return html;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 下载网站图片
     * @param url 网站地址
     * @return 图片地址
     */
    public String doGetImages(String url){
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(this.getRequestConfig());
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode()==200){
                if (httpResponse.getEntity()!=null){
                    /**
                     * 下载图片:
                     *  1.获取图片的后缀
                     *  2.创建图片名,命名图片
                     *  3.下载图片
                     *  4.返回图片名称
                     */
                    //1.获取图片后缀
                    String endName = url.substring(url.lastIndexOf("."));
                    //2.创建图片名,命名图片
                    String picName = UUID.randomUUID().toString()+ endName;
                   //3.下载图片
                    OutputStream outputStream = new FileOutputStream(
                            new File("C:\\Users\\liuqiang132\\Desktop\\java-crawler\\03_jdShop_http_jsoup\\src\\main\\resources\\pic\\"+picName));
                    httpResponse.getEntity().writeTo(outputStream);
                    // 4.返回图片名称
                    return picName;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }

    private RequestConfig getRequestConfig() {
        RequestConfig build = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(100*100)
                .build();
        return build;
    }
}
