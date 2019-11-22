package com.k.i.n.g.f.demo.controller;

import com.k.i.n.g.f.demo.StockTypeEnum;
import com.k.i.n.g.f.demo.feign.DemoFeignClient;
import com.k.i.n.g.f.demo.service.BillService;
import com.k.i.n.g.f.demo.service.HellWorldService;
import com.k.i.n.g.f.demo.service.Hello;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Slf4j
@RequestMapping("/hello")
public class HelloWorld {

    @Autowired
    private  HellWorldService helloWorldService;

    @Autowired
    @Qualifier("in")
    private BillService billService;

    @Autowired
    DemoFeignClient demoFeignClient;

    @Autowired
    private Hello hello;

    /**
     * 这个震惊到我了，居然能把同类型接口的@Service给搞到一个以Service component name为key，Service为值的Map里
     */
    @Autowired
    private Map<String,BillService> serviceMap;

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
        //GsonJsonParser gson = new GsonJsonParser();
        return "hello";
    }

    @GetMapping("/type/jay")
    public StockType index(){
        StockType sk = new StockType();
        sk.setStockType(StockTypeEnum.CG_IN);
       // Hello hello = new Hello();
        //hello.setAge(8);
        //hello.setName("mu");
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
    @GetMapping("/to1")
    public String to1(){
        return new String("to2");
    }

    @GetMapping("/to2")
    public String to2(){
        return new String();
    }

    @GetMapping("/to3")
    public String to3(){
        return demoFeignClient.printDate();
    }
}
