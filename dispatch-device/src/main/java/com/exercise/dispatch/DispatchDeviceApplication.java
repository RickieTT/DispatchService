package com.exercise.dispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.exercise"})
@EnableFeignClients(basePackages = "com.exercise.dispatch.feign")
@EnableScheduling
@EnableAsync
public class DispatchDeviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DispatchDeviceApplication.class, args);
    }
}