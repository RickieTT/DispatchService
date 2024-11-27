package com.exercise.dispatch.controller;

import com.exercise.dispatch.service.device.DeviceTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/device")
@Slf4j
public class DeviceController {

    @Resource
    public DeviceTask deviceTask;

    @GetMapping("/heartbeat")
    public CompletableFuture<Void> triggerAsyncTasks() {
        // 调用10次异步方法，尝试让10个核心线程同时运行
        CompletableFuture[] futures = new CompletableFuture[10];
        for (int i = 0; i < 10; i++) {
            futures[i] = CompletableFuture.runAsync(() -> deviceTask.runExecutor());
        }
        return CompletableFuture.allOf(futures);
    }
}
