package com.k.i.n.g.f.demo.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author dongfei
 */
@Data
@Component
public class Hello {

    @NotBlank(message = "非空")
    @Value("${demo.hello.name:choice}")
    private String name;
    @Min(value = 1,message = "年龄不能小于1")
    private Integer age;
}
