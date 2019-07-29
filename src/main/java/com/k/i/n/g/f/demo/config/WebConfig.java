package com.k.i.n.g.f.demo.config;

import com.k.i.n.g.f.demo.resolver.LoginUserHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author dongfei
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Autowired
    private LoginUserHandlerMethodArgumentResolver userArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }


    @Bean
    public LoginUserHandlerMethodArgumentResolver userArgumentResolver(){
        return new LoginUserHandlerMethodArgumentResolver();
    }

}