package com.course.system.controller;

import com.course.system.domain.Test;
import com.course.system.service.TestService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test() {
        return "success";
    }

    @RequestMapping("/list")
    public List<Test> list() {
        System.out.println(1);
        return testService.list();
    }
}
