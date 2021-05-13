package com.common.config;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/12
 * @Description: com.lw.config
 * @version: 1.0
 */
public class BaseDataSourceConfiguration {

    public DataSource getDataSource(String driverClassName,String url,String username,String password){
        DruidDataSource druidDataSource=new DruidDataSource();
        //driverClassName-->配置文件中配置的driver-class-name
        druidDataSource.setDriverClassName(driverClassName);
        //设置数据库的url
        druidDataSource.setUrl(url);
        //设置数据库的用户名
        druidDataSource.setUsername(username);
        //设置数据库的密码
        druidDataSource.setPassword(password);
        //设置初始化建立物理连接的个数，初始化发生在显示调用init方法或第一次getConnection时
        druidDataSource.setInitialSize(20);
        //设置最小连接池数量
        druidDataSource.setMinIdle(5);
        //设置最大连接池数量
        druidDataSource.setMaxActive(300);
        //检测连接是否有效的sql（要求是一个查询语句）
        druidDataSource.setValidationQuery("select 1 from dual");
        //设置连接时最大等待时间，单位毫秒
        druidDataSource.setMaxWait(100000);
        return druidDataSource;


    }

}
