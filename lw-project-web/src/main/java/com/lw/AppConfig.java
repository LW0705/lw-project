package com.lw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
public class AppConfig {

    public static void main(String[] args) {
        //优先执行
        //设置系统属性
        System.setProperty("project-name","lw-project");
        SpringApplication.run(AppConfig.class, args);
    }

    /**
     * 设置默认线程池
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(10);
        //指定最大线程数
        executor.setMaxPoolSize(20);
        //设置队列大小
        executor.setQueueCapacity(200);
        //设置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("thread-lw-");
        //rejection-policy:当pool已经达到max size时，如何处理新任务?
        //CALLER_RUNS:不在新线程中执行任务，而是在有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程空闲后的最大存活时间
        executor.setKeepAliveSeconds(60);
        //执行初始化
        executor.initialize();
        return executor;
    }
}
