package com.lixy.simple.feign.consumer.config;

import com.lixy.simple.feign.consumer.annotation.FeignAttributeAnnotation;
import feign.Contract;
import feign.Logger;
import feign.RequestTemplate;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName  UserFeignConfiguration
 * @Description  TODO
 * @Date  2019/8/4 16:54
 * @author  lixueyun
 * @version  V1.0
 */
@Configuration
public class UserFeignConfiguration extends FeignClientsConfiguration {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;



    //默认使用spring mvc的contract 所以在远程调用的时候可以使用springMVC的注解
    @Bean
    @ConditionalOnMissingBean
    @Override
    public Contract feignContract(ConversionService feignConversionService) {
        return  new feign.Contract.Default();
    }



    //启用feign日志
    @Bean
    @ConditionalOnMissingBean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * @methodName  feignEncoder
     * @description  解决复杂对象get请求无法访问的问题
     * @param
     * @author  lixueyun
     * @Date  2019/8/4 18:14
     * @return  feign.codec.Encoder
     */
    @Bean
    @ConditionalOnMissingBean
    @Override
    public Encoder feignEncoder() {
        SpringEncoder springEncoder = new SpringEncoder(messageConverters);
        //Encoder defaultEncoder = new Encoder.Default();
        return (object, bodyType, template) -> {
            Class clazz = (Class)bodyType;
            if (null != clazz.getAnnotation(FeignAttributeAnnotation.class) ) {
                modelAttributeParamEncoder(clazz,object,template);
            } else {
                springEncoder.encode(object, bodyType, template);
            }
        };
    }

    /**
     * @methodName  modelAttributeParamEncoder
     * @description  modelAttribute参数转换
     * @param clazz
     * @param object
     * @param template
     * @author  lixueyun
     * @Date  2019/8/4 18:14
     * @return  void
     */
    public void modelAttributeParamEncoder(Class clazz, Object object, RequestTemplate template){
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object data = field.get(object);
                if(data == null) continue;
                if(field.getType() == List.class){
                    List<String> s = new ArrayList<>();
                    for(Object o : (List<?>) data){
                        s.add(o.toString());
                    }
                    template.query(field.getName(), s.toArray(new String[]{}));
                } else {
                    template.query(field.getName(), data.toString());
                }
            } catch (IllegalAccessException e) {
                continue;
            }
        }
    }


}
