package com.lixy.simple.ribbon.controller.response;

import lombok.Data;

import java.time.LocalDate;

/**
 * @ClassName  QueryUserResponse
 * @Description
 * @Date  2019/8/1 15:15
 * @author  lixueyun
 */
@Data
public class QueryUserResponse {

    private String id;

    private String name;

    private Integer age;

    private Integer sex;

    private LocalDate birthday;

}
