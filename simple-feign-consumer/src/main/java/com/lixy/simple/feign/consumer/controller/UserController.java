package com.lixy.simple.feign.consumer.controller;

import com.lixy.simple.feign.consumer.api.EurekaClient;
import com.lixy.simple.feign.consumer.api.UserClient;
import com.lixy.simple.feign.consumer.controller.request.QueryUserRequest;
import com.lixy.simple.feign.consumer.controller.response.QueryUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    private UserClient userClient;

    @Autowired
    private EurekaClient eurekaClient;

//    @RequestMapping(value = "/query", method = RequestMethod.GET)
//    public QueryUserResponse queryById(@ModelAttribute QueryUserRequest request){
//        log.info("consumer接收到参数：{}", request);
//        request.setBirthday(LocalDate.now());
//        request.setAge(1);
//        QueryUserResponse response = userClient.queryById(request);
//        return response;
//    }

    @RequestMapping(value = "/query/feignClient", method = RequestMethod.GET)
    public QueryUserResponse query(@ModelAttribute QueryUserRequest request){
        log.info("consumer接收到参数：{}", request);
        request.setBirthday(LocalDate.now());
        request.setAge(12);
        QueryUserResponse response = userClient.queryOfFeignClien(request);
        return response;
    }

    @RequestMapping(value = "/eureka/{serviceName}", method = RequestMethod.GET)
    public String query(@PathVariable(value = "serviceName") String serviceName){
        log.info("consumer接收到参数：{}", serviceName);
        String serverInfo = eurekaClient.findServerInfoByEureka(serviceName);
        return serverInfo;
    }




}
