package org.example.Serivce;


import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author yonsun
 */
@Service
@Component
public class MeterService {

    @Autowired
    MeterRegistry meterRegistry;
    @Autowired
    private CollectorRegistry collectorRegistry;

    private AtomicInteger app_online_count;
    private Gauge my_library_transactions_active ;

    @PostConstruct
    private void init(){

        app_online_count = meterRegistry.gauge("dmdbms.temperature.gauge", Tags.of("site", "SiteA", "cab", "cab01"), new AtomicInteger(0));

        my_library_transactions_active = Gauge.build()
                .name("dmdbms_library_transactions_active")
                .help("Active transactions.")
                .labelNames("wy","zxjr","ocs","xxjf")
                .register(collectorRegistry);
    }


    public void test(){

        System.out.println("111");
        app_online_count.set(new Random().nextInt());
        meterRegistry.gauge("dmdbms.temperature.gauge1111", Tags.of("site", "SiteA", "cab", "cab222"), new AtomicInteger(2222));

        //传参多个值
        my_library_transactions_active.labels("site", "SiteA", "cab", "cab222").set(new Random().nextDouble());
        my_library_transactions_active.labels("site", "SiteB", "cab", "cab333").set(new Random().nextDouble());

    }

}
