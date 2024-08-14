package com.liuqiang.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: liuQiang132
 * @Date: 2024/8/8 13:08 星期四 13:08
 * @Description:
 * @version: 1.0
 **/
@SpringBootApplication
@EnableScheduling
public class MainJDTest {
    public static void main(String[] args) {

        SpringApplication.run(MainJDTest.class,args);
        //需要抓取的目标地址: https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&wq=%E6%89%8B%E6%9C%BA&pvid=9d1ed26d51854b4395e43df61e6dd681


    }
}
