package com.liuqiang.jd.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/9 21:45 星期五 21:45
 * @Description:
 * @version: 1.0
 **/
public class JdTestDemo {
    public static void main(String[] args) throws Exception {

        Map<String,String> map = new HashMap<>();
        map.put("thor","270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078FC310118B00B" +
                "76F317344C2D0C34A4472882BE6FFBEDB348F5C4CD212D7E2065079D9D269EDC" +
                "B13E71CAC9382537046C02FA6C584B60F1B8559E0BE4065121790650AC97804E212B4F02E855BBB7B8B07B20BEFB" +
                "C3145331C18B4F6A7DBBC477B9403F91591152D198E8A60A917896A1E6" +
                "08BB140A99DE4D64817DAFEAD00285145F835243FB");
        Document document = Jsoup.connect("https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&suggest=" +
                "1.his.0.0&wq=%E6%89%8B%E6%9C%BA&pvid=f131db6fcc18456b8c8b2ae05155c7e9&isList=0&" +
                "page=3&s=56&click=0&log_id=1723660140297.9089").cookies(map).get();
        System.out.println(document);
        //加入thor后能够获取到网站信息,等进一步是否获取到网站数据需待定！！！！！！！！！！
        Element jGoodsList = document.getElementById("J_goodsList");
        assert jGoodsList != null;
        Elements ul = jGoodsList.getElementsByTag("ul");
        for (Element element : ul) {
            Elements li = element.getElementsByTag("li");
            System.out.println(li);
        }



    }
}
