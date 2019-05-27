package com.k.i.n.g.f.demo.controller;

import com.k.i.n.g.f.demo.service.HellWorldService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class HelloWorld {

    @Autowired
    private  HellWorldService helloWorldService;

    @GetMapping("/hello/{name}")
    public String index(@PathVariable("name")  String userName){
        try {
            MDC.put("uuid", UUID.randomUUID().toString());
            helloWorldService.say("hello,bugs");
            helloWorldService.say("hello,boys");
            helloWorldService.say("hello,guys");

        }catch (Exception ex){

        }finally {
            MDC.clear();
        }
        return "Hello," + userName;
    }
}
