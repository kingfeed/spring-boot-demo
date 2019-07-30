package com.k.i.n.g.f.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author dongfei
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class FeignDemo {
    public static void main(String[] args) {
        //此处需要重新配置参数，与DemoApplication区别
            SpringApplication.run(FeignDemo.class, "--spring.application.name=feign-demo",
                    "--server.port=9000",
                    "--spring.main.allow-bean-definition-overriding=true",
                    "--server.servlet.context-path=/");
    }

    @GetMapping("/api") public String printDate() {
        return new Date().toString();
    }
}
