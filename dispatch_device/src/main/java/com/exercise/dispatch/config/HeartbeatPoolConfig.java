package com.exercise.dispatch.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class HeartbeatPoolConfig {

    @Value("1")
    private int zrangeGapSeconds;

    @Value("10000")
    private int workersNum;

    @Value("10")
    private int corePoolSize;

    @Value("10")
    private int maxPoolSize;

    @Value("99999")
    private int queueCapacity;

    @Value("device-")
    private String namePrefix;

}
