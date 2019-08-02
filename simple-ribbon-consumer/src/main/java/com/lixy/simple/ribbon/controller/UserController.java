package com.lixy.simple.ribbon.controller;

import com.lixy.simple.ribbon.controller.request.QueryUserRequest;
import com.lixy.simple.ribbon.controller.response.QueryUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @ClassName  UserController
 * @Description
 * @Date  2019/8/1 15:01
 * @author  lixueyun
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public QueryUserResponse queryById(@ModelAttribute QueryUserRequest request){
        log.info("consumer接收到参数：{}", request);
        QueryUserResponse response = restTemplate.getForObject("http://simple-ribbon-provider/user/query?name=lixueyun&age=12", QueryUserResponse.class);
        return response;
    }


    //不使用eureka
    @RequestMapping(value = "/query/notEureka", method = RequestMethod.GET)
    public QueryUserResponse queryByIdNotEureka(@ModelAttribute QueryUserRequest request){
        log.info("consumer接收到参数：{}", request);

        ServiceInstance instance = loadBalancerClient.choose("simple-ribbon-provider");
        URI providerUri = URI.create(String.format("http://%s:%s/user/query?name=%s&id=%s", instance.getHost(), instance.getPort(), "lixy", 31));
        log.info("调用provider地址为:{}", providerUri.toString());
        QueryUserResponse response = restTemplate.getForObject(providerUri, QueryUserResponse.class);
        return response;
    }
}
