package com;

import com.lw.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//添加classes = {AppConfig.class}是因为单元测试的测试类和启动类不在同一个根目录下
@SpringBootTest(classes = {AppConfig.class})
class AppConfigTests {

    @Test
    void contextLoads() {
    }



}
