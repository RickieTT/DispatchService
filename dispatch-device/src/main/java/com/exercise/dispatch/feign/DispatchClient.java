package com.exercise.dispatch.feign;

import com.exercise.dispatch.dto.HeartbeatDTO;
import com.exercise.dispatch.model.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("dispatch-info")
public interface DispatchClient {

    @PostMapping(value = "/task/listener")
    public ResponseEntity<String> createTimer(@RequestBody HeartbeatDTO heartbeatDTO);


}
