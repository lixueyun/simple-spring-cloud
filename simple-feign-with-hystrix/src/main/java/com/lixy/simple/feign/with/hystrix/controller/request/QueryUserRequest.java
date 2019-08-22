package com.lixy.simple.feign.with.hystrix.controller.request;

import com.lixy.simple.feign.with.hystrix.annotation.FeignAttributeAnnotation;
import lombok.Data;

import java.time.LocalDate;

/**
 * @ClassName  QueryUserRequest
 * @Description
 * @Date  2019/8/1 15:12
 * @author  lixueyun
 */
@Data
@FeignAttributeAnnotation
public class QueryUserRequest {

    private String id;

    private String name;

    private Integer age;

    private Integer sex;

    private LocalDate birthday;

}
