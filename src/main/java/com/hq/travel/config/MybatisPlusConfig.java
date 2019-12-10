package com.hq.travel.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

        @Bean
        public PaginationInterceptor paginationInterceptor(){
            PaginationInterceptor page = new PaginationInterceptor();
            //设置方言类型
            page.setDialectType("mysql");
            return page;
        }
}
