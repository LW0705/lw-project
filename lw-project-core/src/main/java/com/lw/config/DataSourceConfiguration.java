package com.lw.config;

import com.common.config.BaseDataSourceConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/13
 * @Description: com.lw.config
 * @version: 1.0
 */
@Configuration
@MapperScan("com.lw.dao")
public class DataSourceConfiguration extends BaseDataSourceConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean(name="dataSource")
    public DataSource dataSource(){
        return getDataSource(driverClassName,url,username,password);
    }




}
