package com.exercise.dispatch.feign;

import com.exercise.dispatch.model.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "taskClient", url = "http://127.0.0.1:10002")
public interface DispatchClient {

    @PostMapping(value = "/task/listener")
    public ResponseEntity<String> createTimer(@RequestBody String name);


}
