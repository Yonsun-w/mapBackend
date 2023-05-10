package org.example.Interceptor;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import io.prometheus.client.Gauge;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yonsun
 * @(#)PromethuesInterceptor.java, 4月 19, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * @wenjiahua
 */

public class PrometheusMetricsInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CollectorRegistry collectorRegistry;


    static final  Counter requestCounter = Counter.build()
            .name("learn_io_namespace_http_requests_total").labelNames("path", "method", "code")
            .help("Total requests.").register();

    @PostConstruct
    public void init(){
        requestCounter.register(collectorRegistry);
    }

//    @PostConstruct
//    public void init() {
//        requestCounter
//    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        int status = response.getStatus();
        requestCounter.labels(requestURI, method, String.valueOf(status)).inc();
        super.afterCompletion(request, response, handler, ex);
    }
}