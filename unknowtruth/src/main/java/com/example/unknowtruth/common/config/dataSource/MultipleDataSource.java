package com.example.unknowtruth.common.config.dataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.logging.Logger;

/**
 * @Author: hjr
 * @Date: 2019/3/8 11:37
 */
@Slf4j
public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    public Logger getParentLogger() {
        return null;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        log.debug("----------------------------use DataSouce:" + DataSourceContextHolder.getDBType());
        return DataSourceContextHolder.getDBType();
    }
}
