package com.exercise.dispatch.service.device;

import com.exercise.dispatch.dto.HeartbeatDTO;
import com.exercise.dispatch.feign.DispatchClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;


@Component
@Slf4j
public class DeviceTask {
    @Autowired
    public DispatchClient taskClient;


    public void sendHeartbeat(){
        // 调用10次异步方法，尝试让10个核心线程同时运行
        CompletableFuture[] futures = new CompletableFuture[10];
        for (int i = 0; i < 10; i++) {
            AtomicLong id = new AtomicLong(i);
            futures[i] = CompletableFuture.runAsync(() -> this.runExecutor(id));
        }
    }


    @Async("deviceTaskPool")
    public void runExecutor(AtomicLong id){
        HeartbeatDTO heartbeatDTO = new HeartbeatDTO();
        Long deviceId = Objects.isNull(id) ? id.addAndGet(1L) : id.get();
        heartbeatDTO.setDeviceId(deviceId);
        heartbeatDTO.setUsedMemory("4G");
        heartbeatDTO.setUsedDisk("128G");
        heartbeatDTO.setTotalMemory("16G");
        heartbeatDTO.setTotalDisk("512G");
        taskClient.createTimer(heartbeatDTO);
        log.info("设备id为 {} 正在发送心跳", deviceId);
    }

}
