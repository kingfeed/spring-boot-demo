package com.k.i.n.g.f.demo.controller;

import com.k.i.n.g.f.demo.StockTypeEnum;
import com.k.i.n.g.f.demo.service.HellWorldService;
import com.k.i.n.g.f.demo.service.Hello;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import java.util.*;

@RestController
@Slf4j
public class HelloWorld {

    @Autowired
    private  HellWorldService helloWorldService;

    @GetMapping("/hello/jay")
    public String index(Hello hello){

            MDC.put("uuid", UUID.randomUUID().toString());
            //validator.validate(new Hello(),null);
            helloWorldService.say("hello,bugs");
            helloWorldService.say("hello,boys");
            helloWorldService.say("hello,guys");
            helloWorldService.say("dongfei","hello");
            // 普通参数值校验
            //helloWorldService.say(null,"hello");
            //验证无效？？？
            helloWorldService.say(new Hello());
            MDC.clear();
        GsonJsonParser gson = new GsonJsonParser();
        return "hello";
    }

    @GetMapping("/type/jay")
    public StockType index(){
        StockType sk = new StockType();
        sk.setStockType(StockTypeEnum.CG_IN);
        Hello hello = new Hello();
        hello.setAge(8);
        hello.setName("mu");
        sk.setHello(hello);
        MDC.put("uuid", UUID.randomUUID().toString());
        MDC.clear();
        return sk;
    }

    /**
     * [
     *     "1",
     *     "2",
     *     "3",
     *     "4",
     *     "1",
     *     "2"
     * ]
     * @List 后面的1，2存在 1, 2, 3, 4, 1, and 2
     * @Set  后面的1，2不存在 1, 2, 3, and 4
     * @param nameSet
     * @return
     */
    @PostMapping("/string")
    public String toOneString(@RequestBody Set<String> nameSet){
        return StringUtils.joinWithSerialComma(new ArrayList<>(nameSet));
    }

    /**
     * [
     *     "1",
     *     "2"
     * ]
     * @return
     */
    @PostMapping("/set")
    public Set<String> toOneString(){
        Set<String> abc = new HashSet<>();
        abc.add("1");
        abc.add("2");
        return abc;
    }
}
