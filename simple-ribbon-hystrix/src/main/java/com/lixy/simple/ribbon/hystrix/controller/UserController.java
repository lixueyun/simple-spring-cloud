package com.lixy.simple.ribbon.hystrix.controller;

import com.lixy.simple.ribbon.hystrix.controller.request.QueryUserRequest;
import com.lixy.simple.ribbon.hystrix.controller.response.QueryUserResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "queryByIdFallback")
    public QueryUserResponse queryById(@ModelAttribute QueryUserRequest request){
        log.info("consumer接收到参数：{}", request);
        QueryUserResponse response = restTemplate.getForObject("http://simple-ribbon-provider/user/query?name=lixueyun&age=12", QueryUserResponse.class);
        return response;
    }

    public QueryUserResponse queryByIdFallback(QueryUserRequest request){
        QueryUserResponse response = new QueryUserResponse();
        response.setId("123");
        response.setName("fallback");
        response.setAge(0);
        response.setSex(0);
        response.setBirthday(LocalDate.now());
        log.info("断路器触发!");
        return response;
    }

}
