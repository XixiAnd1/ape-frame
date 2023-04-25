package com.jingdianjichi.config;

import com.jingdianjichi.interceptor.SqlBeautyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfiguration {
    @Bean
    public SqlBeautyInterceptor sqlBeautyInterceptor(){
        return new SqlBeautyInterceptor();
    }
}
