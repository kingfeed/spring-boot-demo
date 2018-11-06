package com.k.i.n.g.f.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name")  String userName){
        return "Hello," + userName;
    }
}
