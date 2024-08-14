package com.liuqiang.jd.task;

import com.liuqiang.jd.utils.ComponentUtils;
import com.liuqiang.jd.utils.httpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URL;

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
            Document document = Jsoup.parse(new URL(resultHtml), 100000);
            //获取页面
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
