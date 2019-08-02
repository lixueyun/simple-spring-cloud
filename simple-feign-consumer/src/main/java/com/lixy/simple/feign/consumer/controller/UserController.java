package com.lixy.simple.feign.consumer.controller;

import com.lixy.simple.feign.consumer.controller.request.QueryUserRequest;
import com.lixy.simple.feign.consumer.controller.response.QueryUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public QueryUserResponse queryById(@ModelAttribute QueryUserRequest request){
        log.info("consumer接收到参数：{}", request);
        QueryUserResponse response = restTemplate.getForObject("http://simple-ribbon-provider/user/query?name=lixueyun&age=12", QueryUserResponse.class);
        return response;
    }
}
