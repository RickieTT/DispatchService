package com.exercise.dispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.exercise.dispatch"})
@EnableScheduling
@EnableAsync
public class DispatchInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DispatchInfoApplication.class, args);
    }

}
