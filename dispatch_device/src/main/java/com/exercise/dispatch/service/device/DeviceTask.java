package com.exercise.dispatch.service.device;

import com.exercise.dispatch.feign.DispatchClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class DeviceTask {
    @Autowired
    public DispatchClient taskClient;

    @Async("deviceTaskPool")
    public void runExecutor(){

        taskClient.createTimer(Thread.currentThread().getName().toString());
        log.info("线程 {} 正在运行异步任务", Thread.currentThread().getName());
    }

}
