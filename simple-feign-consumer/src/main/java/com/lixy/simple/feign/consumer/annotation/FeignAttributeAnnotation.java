package com.lixy.simple.feign.consumer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName  FeignAttributeAnnotation
 * @Description  TODO
 * @Date  2019/8/4 18:02
 * @author  lixueyun
 * @version  V1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FeignAttributeAnnotation {
}
