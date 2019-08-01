package com.lixy.simple.ribbon;

import com.lixy.simple.ribbon.controller.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
//使用自定义ribbon负载 不能被component扫描到
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = RibbonConfig.class)
})
//配置自定义微服务 ribbon负载
@RibbonClient(name = "simple-ribbon-provider", configuration = RibbonConfig.class)
public class SimpleRibbonConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRibbonConsumerApplication.class, args);
    }

}
