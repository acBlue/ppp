package com.yw.core.base.enums;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public class BaseEnumSerializer extends JsonSerializer<BaseEnum> {


	@Override
	@SuppressWarnings("all")
	public void serialize(BaseEnum viewEnum, JsonGenerator jsonGenerator, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("code");
        jsonGenerator.writeObject(viewEnum.getCode());
        jsonGenerator.writeFieldName("desc");
        jsonGenerator.writeString(viewEnum.getDesc());
        jsonGenerator.writeEndObject();


	}
}
