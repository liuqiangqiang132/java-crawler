package com.liuqiang.jd.task;

import com.liuqiang.jd.utils.ComponentUtils;
import com.liuqiang.jd.utils.httpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/8 13:31 星期四 13:31
 * @Description: 使用定时任务抓取京东商城的信息
 * @version: 1.0
 **/
@Component
public class JdTask {

    @Resource
    private ComponentUtils componentUtils;

    @Resource
    private  httpClientUtils httpClientUtils;

    @Scheduled(cron = "*/1 * * * * * ")
    public void init() {
        //获取页面
        String resultHtml = httpClientUtils.doGetHtml(componentUtils.JD_URL);
        //TODO 目前该项目遇到了卡壳，主要是访问不到京东商城页面,正在寻找解决解决方案..........................
        parse(resultHtml);
    }

    /**
     * 解析页面
     * @param resultHtml html网页
     */
    private void parse(String resultHtml) {
        //解析页面
        try {
            Map<String,String> map = new HashMap<>();
            map.put("thor","270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078FC310118B00B76F317344C2D0C34A44728" +
                    "82BE6FFBEDB348F5C4CD212D7E2065079D9D269EDCB13E71CAC9382537046C02FA6C584B60F1B8559E0BE4065121790" +
                    "650AC97804E212B4F02E855BBB7B8B07B20BEFBC3145331C18B4F6A7DBBC477B9403F91591152D198E8A60A917896A1E608" +
                    "BB140A99DE4D64817DAFEAD00285145F835243FB");
            Document document = Jsoup.connect("https://search.jd.com/Search?" +
                    "keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&suggest=1.his.0.0" +
                    "&wq=&pvid=f131db6fcc18456b8c8b2ae05155c7e9").cookies(map).get();
            //获取页面
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
