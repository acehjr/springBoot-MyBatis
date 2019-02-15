package com.example.unknowtruth.common.utils;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.unknowtruth.common.basic.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import java.io.IOException;
import java.util.Locale;
@Slf4j
public class MessageConverter extends FastJsonHttpMessageConverter {

    public MessageConverter() {
        super();
    }

    @Autowired
    private MessageSource messageSource;

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {
        if (obj instanceof ResultDto) {
            ResultDto result = (ResultDto) obj;
            if (StringUtils.isBlank(result.getMsg())) {
                //如果没有msg，就根据code去找标准msg返回
                result.setMsg(
                        //到messages_zh_CN.properties获取信息
                        messageSource.getMessage(
                            String.valueOf(result.getCode()),
                            new Object[]{},
                            Locale.SIMPLIFIED_CHINESE)
                );
            }
            super.writeInternal(result, outputMessage);
        } else {
            super.writeInternal(obj, outputMessage);
        }

    }
}
