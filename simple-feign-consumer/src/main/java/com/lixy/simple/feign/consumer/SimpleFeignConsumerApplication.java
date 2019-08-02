package com.lixy.simple.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SimpleFeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleFeignConsumerApplication.class, args);
    }

}
