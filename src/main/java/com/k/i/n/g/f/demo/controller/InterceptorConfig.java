package com.k.i.n.g.f.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 简单测试下Spring的拦截器功能
 *
 * @author dongfei
 * WebMvcConfigurerAdapter
 */

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册一个新的拦截器，匹配RequestMapping /hello/to1
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                log.warn("to1");
                //此处返回值，如果是false拦截链条终止
                return true;
            }
        }).addPathPatterns("/hello/to1");
        //注册一个新的拦截器，匹配RequestMapping /hello/to2
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                log.warn("to2");
                return true;
            }
        }).addPathPatterns("/hello/to2");
        //这个拦截器，排除to1，对to1不进行拦截处理
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                log.warn("----");
                return true;
            }
        }).excludePathPatterns("/hello/to1");
        //不指定URL，默认不执行任何拦截
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                log.warn("every");
                return true;
            }
        });
        //支持通配符
        //通配符的写法 * (*不能代表所有) 不行 ** (**可以代表所有了但是path要以/开始)不行 必须带个/的**才可以
        /**
         * 默认匹配策略 org.springframework.util.AntPathMatcher
         * Wildcard	Description
         * ?	匹配任何单字符
         * *	匹配0或者任意数量的字符
         * **	匹配0或者更多的目录
         */
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                log.warn("any");
                return true;
            }
        }).addPathPatterns("/**");
    }
    /**
     * 按照注册顺序执行
     * 15:56:38.014 logback [http-nio-8090-exec-2] WARN  c.k.i.n.g.f.d.c.InterceptorConfig traceId: - to2
     * 15:56:38.026 logback [http-nio-8090-exec-2] WARN  c.k.i.n.g.f.d.c.InterceptorConfig traceId: - ----
     * 15:56:38.027 logback [http-nio-8090-exec-2] WARN  c.k.i.n.g.f.d.c.InterceptorConfig traceId: - every
     */
    /**
     * 15:57:14.228 logback [http-nio-8090-exec-5] WARN  c.k.i.n.g.f.d.c.InterceptorConfig traceId: - to1
     * 15:57:14.228 logback [http-nio-8090-exec-5] WARN  c.k.i.n.g.f.d.c.InterceptorConfig traceId: - every
     */
}
