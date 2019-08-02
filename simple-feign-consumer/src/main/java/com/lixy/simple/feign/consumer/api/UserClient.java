package com.lixy.simple.feign.consumer.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("simple-ribbon-provider")
public interface UserClient {
}
