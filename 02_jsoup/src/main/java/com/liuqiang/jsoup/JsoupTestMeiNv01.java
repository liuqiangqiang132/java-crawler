package com.liuqiang.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/7 13:21 星期三 13:21
 * @Description: 爬取彼岸图网图片
 * @version: 1.0
 **/
public class JsoupTestMeiNv01 {
    public static void main(String[] args) throws Exception {

        //目标网址:   默认:  https://pic.netbian.com/4kmeinv/  也可以是这个(https://pic.netbian.com/4kmeinv/index_1.html)

        //翻页网址: https://pic.netbian.com/4kmeinv/index_2.html

        //1.获取目标网址的网页---->html
        //测试下载时长
        Long start = System.currentTimeMillis();

        /**
         * 因为不知道怎样获取总页码,所以通过查看发现
         */
        for (int i = 2; i <= 51; i++) {
            Document document = Jsoup.parse(new URL("https://pic.netbian.com/4kmeinv/index_" + i + ".html"), 100000);
            Elements select = document.select("div.slist > ul.clearfix li img");
            for (Element element : select) {
                String srcImg = element.attr("src");
                String altText = element.attr("alt");

                String newSrcImg = "https://pic.netbian.com" + srcImg;

                //下载图片到本地
                getDownloadImg(newSrcImg, altText);

                Long end = System.currentTimeMillis();

                System.out.println("下载图片的总时长:" + (end - start) / 1000 + "秒");

            }
        }

    }

    /**
     * 使用NIO中的API下载图片到本地文件夹中
     *
     * @param newSrcImg 图片地址
     * @param altText   图片的内容概述
     */
    private static void getDownloadImg(String newSrcImg, String altText) {
        try {
            URLConnection urlConnection = new URL(newSrcImg).openConnection();
            urlConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36 Edg/127.0.0.0");
            InputStream inputStream = urlConnection.getInputStream();
//            Files.copy(inputStream, Paths.get("C:\\Users\\liuqiang132\\Desktop\\彼岸图库\\"+altText+".jpg"));

            Files.copy(inputStream, Paths.get("C:\\Users\\liuqiang132\\Desktop\\彼岸图库\\" + System.currentTimeMillis() + ".jpg"));

            System.out.println(altText + "下载完毕！！！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
