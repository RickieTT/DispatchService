package com.exercise.dispatch.controller;

import com.exercise.dispatch.model.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @PostMapping("/listener")
    public ResponseEntity<String> test(@RequestBody String name) {
        System.out.println(name);
        log.info("get name:{}", name);
        return ResponseEntity.ok("get");
    }

}
