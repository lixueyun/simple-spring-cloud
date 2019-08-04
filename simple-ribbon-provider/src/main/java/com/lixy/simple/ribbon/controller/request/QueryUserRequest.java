package com.lixy.simple.ribbon.controller.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @ClassName  QueryUserRequest
 * @Description
 * @Date  2019/8/1 15:12
 * @author  lixueyun
 */
@Data
public class QueryUserRequest {

    private String id;

    private String name;

    private Integer age;

    private Integer sex;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;

}
