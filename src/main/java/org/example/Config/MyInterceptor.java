package org.example.Config;

import org.example.Interceptor.PrometheusMetricsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yonsun
 * @(#)Promthues.java, 4月 19, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * @wenjiahua
 */

@Configuration
public class MyInterceptor implements WebMvcConfigurer {
    @Bean
    public PrometheusMetricsInterceptor prometheusMetricsInterceptor() {
        return new PrometheusMetricsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(prometheusMetricsInterceptor())  // 添加拦截器
                .addPathPatterns("/**")          // 配置拦截请求url（ ** 表示拦截所有请求url）
                .excludePathPatterns("/hello"); // 排除某些不需要拦截的请求url（即带有/hello请求不会被拦截）
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")   // 配置需要添加静态资源的请求url
                .addResourceLocations("classpath:/**");   //配置静态资源路径
    }
}