package com.lw.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.common.config.BaseDataSourceConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/13
 * @Description: com.lw.config
 * @version: 1.0
 */

/**
 * @Configuration:用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法， 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
 * 并用于构建bean定义，初始化Spring容器。
 */

//@Configuration标注在类上，相当于把该类作为Spring的xml配置文件中的<beans>，作用为：配置spring容器（应用上下文）
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

    /**
     * @Bean标注在方法上，等价于spring的xml配置文件中的<bean>，作用为：注册bean对象
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        return getDataSource(driverClassName, url, username, password);
    }

    //配置Druid监控管理后台的servlet
    //内置Servlet容器时没有web.xml文件，所以使用Spring Boot的注册servlet方式
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        //这些参数可以在com.alibaba.druid.support.http.StatViewServlet的父类
        //com.alibaba.druid.support.http.ResourceServlet中找到
        //后台管理界面的登录账号(用户名字段必须为loginUsername)
        map.put("loginUsername", "admin");
        //后台管理界面的登录密码(密码字段必须为loginPassword)
        map.put("loginPassword", "123456");

        /**
         * allow:Druid后台允许谁可以访问
         * map.put("allow","localhost"); 表示只有本机可以访问
         * map.put("allow","");  为空或者为null时，表示允许所有访问
         *
         * deny:Druid后台拒绝谁访问
         * map.put("deny","118.178.138.167");   表示禁止此ip访问
         */
        map.put("allow", "");

        //设置初始化参数
        bean.setInitParameters(map);
        return bean;
    }

    //通过FilterRegistrationBean实例注册，实现过滤器
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        //注册过滤器
        bean.setFilter(new WebStatFilter());
        //过滤器名字
//        bean.setName("webStatFilter");
        //优先级，越低越优先
//        bean.setOrder(1);//最顶级


        //exclusions:设置哪些请求进行过滤排除掉，从而不进行统计。
        Map<String,String> map=new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid/*,/jdbc/*");
        //设置初始化的参数
        bean.setInitParameters(map);

        //"/*"表示过滤所有请求
        //设置拦截路径
//        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }


}
