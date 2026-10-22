package com.liuqiang.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 使用webmagic抓取图片
 *
 *
 *
 *
 */
public class Demo01 implements PageProcessor {


    @Override
    public void process(Page page) {

        page.putField("html",page.getHtml().$(""));

    }

//爬虫的配置
    @Override
    public Site getSite() {
        Site site = Site.me();
        site.setCharset("utf-8");
        site.setSleepTime(1000);
        site.setTimeOut(10000);
        site.setCycleRetryTimes(3);
        return site;
    }

    public static void main(String[] args) {


// 爬虫程序的启动
        Spider.create(new Demo01()).addUrl("")
                .thread(10)
                .start();


    }
}
