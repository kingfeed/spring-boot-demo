package com.k.i.n.g.f.demo.service;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author dongfei
 */
@Data
public class Hello {

    @NotBlank(message = "非空")
    private String name;
    @Min(value = 1,message = "年龄不能小于1")
    private Integer age;
}
