package com.lixy.simple.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SimpleRibbonProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRibbonProviderApplication.class, args);
    }

}
