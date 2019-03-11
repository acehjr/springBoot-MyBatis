package com.example.unknowtruth.common.config.dataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjr
 * @Date: 2019/3/7 17:27
 * 必须等DataSourceConfiguration加载完才加载
 */
@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
public class MybatisConfiguration extends MybatisAutoConfiguration {

    public MybatisConfiguration(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }


    @Resource(name = "masterDatasource")
    private DataSource masterDataSource;
    @Resource(name = "slaveDatasource")
    private DataSource slaveDataSource;

    @Bean(name = "multipleDataSource")
    public MultipleDataSource multipleDataSource(){
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>(2);
        targetDataSources.put(DataSourceContextHolder.DbType.MASTER,masterDataSource);
        targetDataSources.put(DataSourceContextHolder.DbType.SLAVE,slaveDataSource);
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        multipleDataSource.setTargetDataSources(targetDataSources);
        multipleDataSource.setDefaultTargetDataSource(masterDataSource);
        return multipleDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        return super.sqlSessionFactory(multipleDataSource());
    }
}
