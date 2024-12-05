package com.exercise.dispatch.controller;

import com.exercise.dispatch.model.ResponseEntity;
import com.exercise.dispatch.model.ResponseEnum;
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
    public ResponseEntity<String> triggerAsyncTasks() {
        try {
            deviceTask.sendHeartbeat();
        } catch (Exception e) {
            return ResponseEntity.fail(ResponseEnum.FAIL, e.getMessage());
        }
        return ResponseEntity.ok("发送心跳成功");
    }
}
