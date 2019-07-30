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
    @GetMapping("demo/api")
    String printDate();
}
