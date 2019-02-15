package com.example.unknowtruth.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.example.unknowtruth.common.utils.MessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hjr
 * @Date: 2019/2/15 15:58
 */
@Configuration
public class MessageBean {
    @Bean("messageSource")
    public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource(){
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasenames("classpath:i18n/messages/messages");
        reloadableResourceBundleMessageSource.setUseCodeAsDefaultMessage(false);
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        reloadableResourceBundleMessageSource.setCacheSeconds(60);
        return reloadableResourceBundleMessageSource;
    }

//    @Bean
//    public MessageConverter messageConverter(){
//        MessageConverter messageConverter = new MessageConverter();
//        //fastjson配置
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteNullStringAsEmpty,
//                SerializerFeature.DisableCircularReferenceDetect);
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        //处理中文乱码问题
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        //在convert中添加配置信息.
//        messageConverter.setSupportedMediaTypes(fastMediaTypes);
//        messageConverter.setFastJsonConfig(fastJsonConfig);
//        return messageConverter;
//    }
}
