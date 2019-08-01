package com.lixy.simple.ribbon.controller;

import com.lixy.simple.ribbon.controller.request.QueryUserRequest;
import com.lixy.simple.ribbon.controller.response.QueryUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public QueryUserResponse queryById(@ModelAttribute QueryUserRequest request){
        log.info("provider接收到参数：{}", request);
        QueryUserResponse response = new QueryUserResponse();
        BeanUtils.copyProperties(request, response);
        return response;
    }
}
