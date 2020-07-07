package com.example.demo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// 说明全局配置类    --- 跨域请求
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")          // 访问的路径
                .allowedOrigins("Http://localhost:8080","null")         // 请求来源
                .allowedMethods("GET","PUT","POST","OPTIONS","DELETE")      // 方法
                .allowCredentials(true)             // 允许携带
                .maxAge(3600);              // 响应时间
    }
}
