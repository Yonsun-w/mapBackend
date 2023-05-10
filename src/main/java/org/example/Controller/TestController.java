package org.example.Controller;


import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yonsun
 * @(#)testController.java, 4月 19, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * @wenjiahua
 */
@RestController
public class TestController {
    @Autowired
    MeterRegistry meterRegistry;
    @Autowired
    private CollectorRegistry collectorRegistry;



    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}