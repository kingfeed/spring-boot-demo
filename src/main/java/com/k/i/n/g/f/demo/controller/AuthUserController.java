package com.k.i.n.g.f.demo.controller;

import com.k.i.n.g.f.demo.entity.AuthUser;
import com.k.i.n.g.f.demo.resolver.LoginUser;
import com.k.i.n.g.f.demo.service.ResolverDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongfei
 */
@RequestMapping("/auth/user")
@RestController
public class AuthUserController {
    @Autowired
    ResolverDemoService demoService;

    /**
     * RequestBody 已经对参数进行了处理，所以@RequestBody @LoginUser 这种注解的参数不会再处理
     */
    @PostMapping("/resolver")
    public String resolver(@RequestBody AuthUser response,@LoginUser AuthUser user){
        return "hello";
    }

    /**
     * RequestBody 已经对参数进行了处理，所以@RequestBody @LoginUser 这种注解的参数不会再处理
     */
    @PostMapping("/demo")
    public String resolver(@RequestBody AuthUser user){
        demoService.demo(user);
        return "hello";
    }
}
