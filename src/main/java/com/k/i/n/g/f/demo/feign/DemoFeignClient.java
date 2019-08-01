package com.k.i.n.g.f.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author dongfei
 */
@FeignClient("feign-demo")
public interface DemoFeignClient {
    /**
     * 测试Feign调用
     * @return
     */

    @GetMapping("api")
    String printDate();
    /**
     * 由原来的demo/api 修改为api
     * 原因：FeignDemo.class 增加上下文配置不再取配置文件的了 --server.servlet.context-path=/
     */
}
