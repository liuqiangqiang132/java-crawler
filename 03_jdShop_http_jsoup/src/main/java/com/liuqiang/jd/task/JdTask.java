package com.liuqiang.jd.task;

import com.liuqiang.jd.utils.ComponentUtils;
import com.liuqiang.jd.utils.httpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

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

    @Scheduled(fixedDelay = 100*1000)
    public void init() {
        //使用加载cookie的方式进行尝试！！！！！！！
        for (int i = 1; i <10; i=i+2) {
            String html = httpClientUtils.doGetHtml(componentUtils.JD_URL + i);
            parse(html);
        }
        System.out.println("数据抓取完成！！！！");
    }

    /**
     * 解析页面
     * @param html html网页
     */
    private void parse(String html) {
        //解析页面
        try {
            //获取页面
            Document document = Jsoup.connect(html).cookies(componentUtils.getMap()).get();
            //获取页面
            Elements li = document.select("div#J_goodsList > ul.gl-warp li");
            //遍历所有的li标签，显示隐藏在li中数据
            for (Element element : li) {
                System.out.println(element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
