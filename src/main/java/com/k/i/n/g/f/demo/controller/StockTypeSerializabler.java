package com.k.i.n.g.f.demo.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.k.i.n.g.f.demo.StockTypeEnum;

import java.io.IOException;

/**
 * @author dongfei
 */
public class StockTypeSerializabler extends StdSerializer<StockTypeEnum> {

    public StockTypeSerializabler() {
        super(StockTypeEnum.class);
    }


    @Override
    public void serialize(StockTypeEnum stockType, JsonGenerator generator,
                          SerializerProvider provider)
            throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeFieldName("code");
        generator.writeNumber(stockType.getCode());
        generator.writeFieldName("type");
        generator.writeNumber(stockType.getType());
        generator.writeEndObject();
    }

}
