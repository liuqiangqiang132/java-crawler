package com.liuqiang.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/8 03:06 星期四 3:06
 * @Description: Jsoup的API是如何使用
 * @version: 1.0
 **/
public class JsoupAPITest02 {
    public static void main(String[] args) throws Exception {
        //方式一:
        //Document document = Jsoup.parse(new URL(""), 10000);

       //方式二: 创建链接后再获取document对象
        Document document = Jsoup.connect("https://www.hao123.com").get();
        System.out.println(document);

        //方式三:  根据html网页来获取数据的
        Document parse = Jsoup.parse("");






    }
}
