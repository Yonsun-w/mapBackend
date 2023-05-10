package org.example.Config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @(#)CityConfig.java, 5月 10, 2023.
 * <p>
 * Copyright 2023 yuanfudao.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * @wenjiahua
 */
@Component
public class CityConfig {
    Set<String> citys;
    // 类主体部分
    @PostConstruct
    void init() {
        citys = new HashSet<>();
        citys.add("北京市");
        citys.add("北京市");
        citys.add("北京市");
        citys.add("北京市");
        citys.add("北京市");
        citys.add("北京市");
        citys.add("北京市");
        citys.add("北京市");

    }
}