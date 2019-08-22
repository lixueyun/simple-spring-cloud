package com.lixy.simple.feign.with.hystrix.fallback;

import com.lixy.simple.feign.with.hystrix.api.UserClient;
import com.lixy.simple.feign.with.hystrix.controller.request.QueryUserRequest;
import com.lixy.simple.feign.with.hystrix.controller.response.QueryUserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @ClassName  UserFallback
 * @Description
 * @Date  2019/8/22 14:38
 * @author  lixueyun
 */
@Component
public class UserFallback implements UserClient {

    @Override
    public QueryUserResponse queryById(QueryUserRequest request) {
        QueryUserResponse response = new QueryUserResponse();
        response.setId("1");
        response.setName("fallback");
        response.setAge(0);
        response.setSex(1);
        response.setBirthday(LocalDate.now());
        return response;
    }
}
