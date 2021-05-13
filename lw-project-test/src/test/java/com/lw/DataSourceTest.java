package com.lw;

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
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppConfig.class})
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void getConnection() throws SQLException {
        System.err.println(dataSource.getConnection());
    }

}
