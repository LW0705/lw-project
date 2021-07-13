package com.lw;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/13
 * @Description: com.lw
 * @version: 1.0
 */
//添加classes = {AppConfig.class}是因为单元测试的测试类和启动类不在同一个根目录下
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppConfig.class})
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void getConnection() throws SQLException {
        System.err.println(dataSource.getConnection());
        DruidDataSource druidDataSource=(DruidDataSource) dataSource;
        System.err.println("druidDataSource 数据源最大连接数："+druidDataSource.getMaxActive());
        System.err.println("druidDataSource 数据源初始化连接数："+druidDataSource.getInitialSize());
    }

}
