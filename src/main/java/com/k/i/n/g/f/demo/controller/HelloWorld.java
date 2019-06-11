package com.k.i.n.g.f.demo.controller;

import com.k.i.n.g.f.demo.service.HellWorldService;
import com.k.i.n.g.f.demo.service.Hello;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@RestController
@Slf4j
public class HelloWorld {

    @Autowired
    private  HellWorldService helloWorldService;

    @Autowired
    private Validator validator;

    @GetMapping("/hello/jay")
    public String index(Hello hello){

            MDC.put("uuid", UUID.randomUUID().toString());
            //validator.validate(new Hello(),null);
            helloWorldService.say("hello,bugs");
            helloWorldService.say("hello,boys");
            helloWorldService.say("hello,guys");
            helloWorldService.say("dongfei","hello");
            helloWorldService.say(null,"hello");
            //验证无效？？？
            helloWorldService.say(new Hello());
            MDC.clear();
        return "Hello";
    }
}
