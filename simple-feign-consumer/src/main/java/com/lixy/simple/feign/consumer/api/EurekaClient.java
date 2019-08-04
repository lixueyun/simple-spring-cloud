package com.lixy.simple.feign.consumer.api;

import com.lixy.simple.feign.consumer.config.EurekaFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName  EurekaClient
 * @Description  TODO
 * @Date  2019/8/4 19:52
 * @author  lixueyun
 * @version  V1.0
 */
@FeignClient(name = "xxx", url = "http://localhost:8761/", configuration = {EurekaFeignConfiguration.class})
public interface EurekaClient {

    @RequestMapping(value = "/eureka/apps/{serviceName}")
    String findServerInfoByEureka(@PathVariable("serviceName") String serviceName);

}
