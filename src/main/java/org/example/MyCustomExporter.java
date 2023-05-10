//package org.example;
//import io.prometheus.client.Collector;
//import io.prometheus.client.Gauge;
//import io.prometheus.client.Counter;
//import io.prometheus.client.GaugeMetricFamily;
//import io.prometheus.client.exporter.HTTPServer;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
///**
// * @(#)MyCustomExporter.java, 4月 19, 2023.
// * <p>
// * Copyright 2023 yuanfudao.com. All rights reserved.
// * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
// * @wenjiahua
// */
//public class MyCustomExporter extends Collector {
//    private final Random rnd = new Random();
//
//    private final Gauge myGauge = Gauge.build()
//            .name("my_gauge1")
//            .help("This is my custom gauge metric" )
//            .register();
//
//    private final Counter myCounter = Counter.build()
//            .name("my_counter1" )
//            .help("This is MyCustomExporter1 custom counter metric" )
//            .register();
//
//
//
//    @Override
//    public List<MetricFamilySamples> collect() {
//
//        List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
//        // With no labels.
//        mfs.add(new GaugeMetricFamily("my_gauge_2", "help", 42));
//        // With labels
//        GaugeMetricFamily labeledGauge = new GaugeMetricFamily("my_other_gauge", "help", Arrays.asList("labelname"));
//        labeledGauge.addMetric(Arrays.asList("foo"), 4 + rnd.nextInt());
//        labeledGauge.addMetric(Arrays.asList("bar"), 5 + rnd.nextInt());
//        mfs.add(labeledGauge);
//        myCounter.inc();
//        System.out.println("collect");
//        return mfs;
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        // Serve Prometheus metrics on 8080
//        HTTPServer server = new HTTPServer(8080);
//        new YourCustomCollector().register();
//
//    }
//}
//
//
//
//class YourCustomCollector extends Collector {
//
//    @Override
//    public List<MetricFamilySamples> collect() {
//        List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
//
//        String metricName = "my_guage_1";
//
//        // Your code to get metrics
//
//        MetricFamilySamples.Sample sample = new MetricFamilySamples.Sample(metricName, Arrays.asList("l1"), Arrays.asList("v1"), 4);
//        MetricFamilySamples.Sample sample2 = new MetricFamilySamples.Sample(metricName, Arrays.asList("l1", "l2"), Arrays.asList("v1", "v2"), 3);
//
//        MetricFamilySamples samples = new MetricFamilySamples(metricName, Type.GAUGE, "help", Arrays.asList(sample, sample2));
//
//
//        String metricName2 = "my_guage_2";
//
//        // Your code to get metrics
//
//        MetricFamilySamples.Sample sample_2 = new MetricFamilySamples.Sample(metricName2, Arrays.asList("l1"), Arrays.asList("v1"), 4);
//        MetricFamilySamples samples2 = new MetricFamilySamples(metricName2, Type.GAUGE, "help", Arrays.asList(sample_2));
//
//        mfs.add(samples);
//        mfs.add(samples2);
//        return mfs;
//    }
//}