package com.lixy.simple.feign.consumer.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName  EurekaFeignConfigration
 * @Description  TODO
 * @Date  2019/8/4 19:56
 * @author  lixueyun
 * @version  V1.0
 */
@Configuration
public class EurekaFeignConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return  new BasicAuthRequestInterceptor("lixy", "Ml06200818");
    }
}
