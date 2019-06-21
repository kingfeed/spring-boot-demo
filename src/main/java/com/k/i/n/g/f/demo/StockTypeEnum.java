package com.k.i.n.g.f.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.k.i.n.g.f.demo.controller.StockTypeSerializabler;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dongfei
 */
@Getter
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
//@JsonSerialize(using = StockTypeSerializabler.class) 定义在枚举定义上不灵活，其他可能有用字符串的 即原始转化
// 形如 new ObjectMapper().writeValueAsString(StockTypeEnum.CG_IN); 值 为 CG_IN
public enum StockTypeEnum {

    CG_IN(123,456);

    private Integer code;

    private Integer type;

    StockTypeEnum(Integer code,Integer type){
        this.code = code;
        this.type = type;
    }


}
