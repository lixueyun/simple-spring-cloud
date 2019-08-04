package com.lixy.simple.feign.consumer;

import com.lixy.simple.feign.consumer.config.UserFeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients

//如果自定义feign在扫描路径下 需要排除掉
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {UserFeignConfiguration.class})
})
public class SimpleFeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleFeignConsumerApplication.class, args);
    }

}
