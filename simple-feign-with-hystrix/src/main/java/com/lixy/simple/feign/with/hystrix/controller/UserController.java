package com.lixy.simple.feign.with.hystrix.controller;

import com.lixy.simple.feign.with.hystrix.api.UserClient;
import com.lixy.simple.feign.with.hystrix.api.UserClientFactory;
import com.lixy.simple.feign.with.hystrix.controller.request.QueryUserRequest;
import com.lixy.simple.feign.with.hystrix.controller.response.QueryUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private UserClientFactory userClientFactory;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public QueryUserResponse queryById(@ModelAttribute QueryUserRequest request){
        log.info("consumer接收到参数：{}", request);
        QueryUserResponse response = userClient.queryById(request);
        return response;
    }

    @RequestMapping(value = "/queryFactory", method = RequestMethod.GET)
    public QueryUserResponse queryFactory(@ModelAttribute QueryUserRequest request){
        log.info("consumer接收到参数：{}", request);
        QueryUserResponse response = userClientFactory.queryById(request);
        return response;
    }
}
