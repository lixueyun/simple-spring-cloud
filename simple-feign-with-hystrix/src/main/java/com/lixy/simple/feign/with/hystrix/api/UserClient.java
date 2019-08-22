package com.lixy.simple.feign.with.hystrix.api;

import com.lixy.simple.feign.with.hystrix.controller.request.QueryUserRequest;
import com.lixy.simple.feign.with.hystrix.controller.response.QueryUserResponse;
import com.lixy.simple.feign.with.hystrix.fallback.UserFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "simple-ribbon-provider", fallback = UserFallback.class)
public interface UserClient {

    @RequestMapping(value = "/user/query", method = RequestMethod.GET)
    QueryUserResponse queryById(@ModelAttribute QueryUserRequest request);


//    @RequestLine("GET /user/query")
//    QueryUserResponse queryOfFeignClien(@QueryMap QueryUserRequest request);


}
