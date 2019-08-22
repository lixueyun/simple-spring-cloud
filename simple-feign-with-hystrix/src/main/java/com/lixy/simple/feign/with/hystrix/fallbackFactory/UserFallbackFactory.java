package com.lixy.simple.feign.with.hystrix.fallbackFactory;

import com.lixy.simple.feign.with.hystrix.api.UserClientFactory;
import com.lixy.simple.feign.with.hystrix.controller.request.QueryUserRequest;
import com.lixy.simple.feign.with.hystrix.controller.response.QueryUserResponse;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @ClassName  UserFallbackFactory
 * @Description
 * @Date  2019/8/22 15:04
 * @author  lixueyun
 */
@Component
@Slf4j
public class UserFallbackFactory implements FallbackFactory<UserClientFactory> {
    @Override
    public UserClientFactory create(Throwable throwable) {
        log.info("熔断生效,异常原因:{}", throwable.getMessage());
        return new UserClientFactory() {
            @Override
            public QueryUserResponse queryById(QueryUserRequest request) {
                QueryUserResponse response = new QueryUserResponse();
                response.setId("333");
                response.setName("fallbackFactory");
                response.setAge(0);
                response.setSex(0);
                response.setBirthday(LocalDate.now());
                return response;
            }
        };
    }
}
