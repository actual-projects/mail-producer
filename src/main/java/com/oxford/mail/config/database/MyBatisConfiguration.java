package com.oxford.mail.config.database;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.util.SoftHashMap;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * MyBatis配置 - 使用MyBatis的SqlSessionFactory管理数据源
 *
 * @author Chova
 * @date 2020-11-02
 */
@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
public class MyBatisConfiguration extends MybatisAutoConfiguration {

    @Resource(name = "masterDataSource")
    private DataSource masterDataSource;

    @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;

    public MyBatisConfiguration(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        return super.sqlSessionFactory(routingDataSource());
    }

    /**
     * 获取路由数据源
     *
     * @return AbstractRoutingDataSource 路由数据源
     */
    public AbstractRoutingDataSource routingDataSource() {
        ReadWriteSeparateRoutingDataSource routingDataSource = new ReadWriteSeparateRoutingDataSource();

        // 配置保存的目标数据源
        SoftHashMap targetDataSource = new SoftHashMap();
        targetDataSource.put(DataSourceContextHolder.DataSourceType.MASTER, masterDataSource);
        targetDataSource.put(DataSourceContextHolder.DataSourceType.SLAVE, slaveDataSource);
        // 设置默认数据源
        routingDataSource.setDefaultTargetDataSource(slaveDataSource);
        // 设置路由的数据源
        routingDataSource.setTargetDataSources(targetDataSource);
        return routingDataSource;
    }
}
