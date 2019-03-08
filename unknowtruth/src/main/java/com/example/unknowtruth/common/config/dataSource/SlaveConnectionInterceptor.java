package com.example.unknowtruth.common.config.dataSource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Author: hjr
 * @Date: 2019/3/8 11:50
 */
@Aspect
@Component
@Slf4j
public class SlaveConnectionInterceptor  {

    @Around("@annotation(SlaveConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            log.info("set database connection to salve");
            DataSourceContextHolder.setDBType(DataSourceContextHolder.DbType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        }finally {
            DataSourceContextHolder.clearDBType();
            log.info("restore database connection");
        }
    }
}
