package com.k.i.n.g.f.demo.resolver;

import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.*;

/**
 * @author dongfei
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LoginUser{
}
