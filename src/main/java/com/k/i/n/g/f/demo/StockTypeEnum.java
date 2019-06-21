package com.k.i.n.g.f.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dongfei
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StockTypeEnum {

    CG_IN(123,456);

    private Integer code;

    private Integer type;

    StockTypeEnum(Integer code,Integer type){
        this.code = code;
        this.type = type;
    }


}
