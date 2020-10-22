package com.oxford.mail.config.database;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 数据源配置
 *
 * @author Chova
 * @date 2020-06-02
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {
    private static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfiguration.class);
    /**
     * 获取druid.type的属性值
     */
    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    /**
     * 获取主数据源
     *
     * @return DataSource 主数据源
     * @throws SQLException
     */
    @Bean("masterDataSource")
    /** 如果在注入的时候，发现有多个匹配的bean，优先选择有@Primary注解的bean */
    @Primary
    @ConfigurationProperties(prefix = "druid.master")
    public DataSource masterDataSource() throws SQLException {
        DataSource masterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        LOGGER.info("MASTER:" + masterDataSource);
        return masterDataSource;
    }

    /**
     * 获取从数据源
     *
     * @return DataSource 从数据源
     * @throws SQLException
     */
    @Bean("slaveDataSource")
    @ConfigurationProperties(prefix = "druid.slave")
    public DataSource slaveDataSource() throws SQLException {
        DataSource slaveDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        LOGGER.info("SlAVE:" + slaveDataSource);
        return slaveDataSource;
    }

    /**
     * 向容器中注册druidServlet
     *
     * @return ServletRegistrationBean 注册的druidServlet的bean
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new StatViewServlet());
        registrationBean.addUrlMappings("/druid/*");
        registrationBean.addInitParameter("allow", "localhost");
        registrationBean.addInitParameter("deny", "/deny");
        LOGGER.info("druid console manager init:{}", registrationBean);
        return registrationBean;
    }

    /**
     * 向容器中注册druid过滤器
     *
     * @return FilterRegistrationBean druid过滤器
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js, *.gif, *.jpg, *.png, *.css, *.ico, /druid/*");
        LOGGER.info("druid filter register : {}", filterRegistrationBean);
        return filterRegistrationBean;
    }
}
