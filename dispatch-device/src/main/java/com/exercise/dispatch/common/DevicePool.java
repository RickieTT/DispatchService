package com.exercise.dispatch.common;

import com.exercise.dispatch.config.HeartbeatPoolConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 设备池 通过线程池模拟设备
 */
@Configuration
@EnableAsync
@Slf4j
public class DevicePool {

    @Resource
    HeartbeatPoolConfig heartbeatPoolConfig;

    @Bean(name = "deviceTaskPool")
    public Executor devicePoolExecutor(){
        log.info("start device pool executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(heartbeatPoolConfig.getCorePoolSize());
        // 配置最大线程数
        executor.setMaxPoolSize(heartbeatPoolConfig.getMaxPoolSize());
        // 配置队列大小
        executor.setQueueCapacity(heartbeatPoolConfig.getQueueCapacity());
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(heartbeatPoolConfig.getNamePrefix());
        // 配置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }
}
