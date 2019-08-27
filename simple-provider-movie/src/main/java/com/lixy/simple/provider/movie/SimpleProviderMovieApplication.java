package com.lixy.simple.provider.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SimpleProviderMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleProviderMovieApplication.class, args);
    }

}
