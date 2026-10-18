package com.liuqiang.jd.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: liuQiang132
 * @Date: 2024/8/8 15:23 星期四 15:23
 * @Description: MyBatisPlus的配置文件
 * @version: 1.0
 **/
@Configuration
public class MyBatisPlusConfig {
    /**
     * 添加分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor(); //配置分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor()); //乐观锁的实现原理
        return interceptor;
    }

}
