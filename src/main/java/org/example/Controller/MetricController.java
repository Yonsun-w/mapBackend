package org.example.Controller;

import org.example.Serivce.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class MetricController {

    @Resource
    MeterService meterService;

    @RequestMapping("/metric1")
    public String metric() {

        meterService.test();
        return "custom metric test";
    }
}
