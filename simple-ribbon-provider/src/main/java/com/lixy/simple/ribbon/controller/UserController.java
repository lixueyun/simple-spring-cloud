package com.lixy.simple.ribbon.controller;

import com.lixy.simple.ribbon.controller.request.QueryUserRequest;
import com.lixy.simple.ribbon.controller.response.QueryUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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


    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public QueryUserResponse queryById(@ModelAttribute QueryUserRequest request){
        log.info("provider接收到参数：{}", request);
        QueryUserResponse response = new QueryUserResponse();
        BeanUtils.copyProperties(request, response);
        return response;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public QueryUserResponse getById(@PathVariable(value = "id") String id){
        log.info("provider接收到参数：{}", id);
        QueryUserResponse response = new QueryUserResponse();
        response.setId(id);
        response.setName("测试用户");
        response.setAge(0);
        response.setSex(0);
        response.setBirthday(LocalDate.now());
        return response;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public QueryUserResponse saveUser(@RequestBody QueryUserRequest request){
        log.info("provider接收到参数：{}", request);
        QueryUserResponse response = new QueryUserResponse();
        BeanUtils.copyProperties(request, response);
        response.setName("保存成功");
        response.setBirthday(LocalDate.now());
        return response;
    }

}
