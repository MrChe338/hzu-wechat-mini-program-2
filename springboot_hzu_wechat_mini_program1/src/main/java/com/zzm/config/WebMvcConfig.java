package com.zzm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 使用@Configuration注解，表明这是一个Spring配置类
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // 实现WebMvcConfigurer接口中的addCorsMappings方法，用于添加CORS映射规则
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 将"/**"路径映射到所有源，并允许跨域请求使用指定的HTTP方法
        registry.addMapping("/**")
                .allowedOriginPatterns("http://localhost:8080") // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // 允许的HTTP方法
                .allowedHeaders("*") // 允许的请求头
                .allowCredentials(true); // 启用凭据支持
    }
}

