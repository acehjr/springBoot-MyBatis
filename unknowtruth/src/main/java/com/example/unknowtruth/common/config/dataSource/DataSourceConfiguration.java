package com.example.unknowtruth.common.config.dataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author: hjr
 * @Date: 2019/3/7 17:29
 */
@Configuration
public class DataSourceConfiguration {
    @Value("${master.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "masterDatasource")
    @ConfigurationProperties(prefix = "master.datasource")
    public DataSource masterDatasource() {
        System.out.println("-------------------- writeDataSource init ---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "slaveDatasource")
    @ConfigurationProperties(prefix = "slave.datasource")
    public DataSource slaveDatasource() {
        System.out.println("-------------------- readDataSourceOne init ---------------------");
        DataSource ds = DataSourceBuilder.create().type(dataSourceType).build();
        System.out.println("-------------------- readDataSourceOne done ---------------------");
        return ds;
    }
}
