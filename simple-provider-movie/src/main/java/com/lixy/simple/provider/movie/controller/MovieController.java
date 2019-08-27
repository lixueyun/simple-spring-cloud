package com.lixy.simple.provider.movie.controller;

import com.lixy.simple.provider.movie.request.QueryMovieRequest;
import com.lixy.simple.provider.movie.response.QueryMovieResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName  MovieController
 * @Description
 * @author  lixueyun
 * @Date  2019/8/26 15:28
 */
@RestController
@RequestMapping(value = "/movie")
@Slf4j
public class MovieController {


    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public QueryMovieResponse queryById(@ModelAttribute QueryMovieRequest request){
        log.info("provider接收到参数：{}", request);
        QueryMovieResponse response = new QueryMovieResponse();
        BeanUtils.copyProperties(request, response);
        return response;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public QueryMovieResponse getById(@PathVariable(value = "id") String id){
        log.info("provider接收到参数：{}", id);
        QueryMovieResponse response = new QueryMovieResponse();
        response.setId(id);
        response.setName("测试电影");
        return response;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public QueryMovieResponse saveUser(@RequestBody QueryMovieRequest request){
        log.info("provider接收到参数：{}", request);
        QueryMovieResponse response = new QueryMovieResponse();
        BeanUtils.copyProperties(request, response);
        response.setName("保存电影");
        return response;
    }

}
