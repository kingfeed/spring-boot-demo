package com.k.i.n.g.f.demo.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.k.i.n.g.f.demo.StockTypeEnum;
import com.k.i.n.g.f.demo.service.Hello;
import lombok.Data;

/**
 * @author dongfei
 */
@Data
public class StockType  {

    /**
     * 注解形式测试
     * 1.@JsonSerialize(using = StockTypeSerializabler.class) 属性定义、枚举定义
     * 2.@JsonFormat(shape = JsonFormat.Shape.OBJECT) 枚举定义
     */
    @JsonSerialize(using = StockTypeSerializabler.class)
    private StockTypeEnum stockType;

    private Hello hello;
}
