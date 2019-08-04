package com.lixy.simple.feign.consumer.api;

import com.lixy.simple.feign.consumer.config.UserFeignConfiguration;
import com.lixy.simple.feign.consumer.controller.request.QueryUserRequest;
import com.lixy.simple.feign.consumer.controller.response.QueryUserResponse;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "simple-ribbon-provider", configuration = UserFeignConfiguration.class)
public interface UserClient {

//    @RequestMapping(value = "/user/query", method = RequestMethod.GET)
//    QueryUserResponse queryById(@ModelAttribute QueryUserRequest request);


    @RequestLine("GET /user/query")
    QueryUserResponse queryOfFeignClien(@QueryMap QueryUserRequest request);


}
