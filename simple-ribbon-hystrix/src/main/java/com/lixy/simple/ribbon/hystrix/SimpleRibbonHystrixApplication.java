package com.lixy.simple.ribbon.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class SimpleRibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRibbonHystrixApplication.class, args);
    }

}
