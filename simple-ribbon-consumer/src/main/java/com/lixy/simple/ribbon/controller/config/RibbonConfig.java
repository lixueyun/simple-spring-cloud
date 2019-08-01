package com.lixy.simple.ribbon.controller.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName  RibbonConfig
 * @Description ribbon自定义负载  随机
 * @Date  2019/8/1 17:48
 * @author  lixueyun
 */
@Configuration
public class RibbonConfig {

    @Autowired
    private IClientConfig clientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig clientConfig){
        return new RoundRobinRule();
    }

}
