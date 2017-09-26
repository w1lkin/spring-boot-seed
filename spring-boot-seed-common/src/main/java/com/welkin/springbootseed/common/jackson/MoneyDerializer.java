package com.welkin.springbootseed.common.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.welkin.springbootseed.common.ApiResponseCode;
import com.welkin.springbootseed.common.exception.BizException;
import com.welkin.springbootseed.common.util.Calculator;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class MoneyDerializer extends JsonDeserializer<Long> {
  @Override
  public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    String valueAsString = p.getValueAsString();
    if (StringUtils.isEmpty(valueAsString)) return null;
    try {
      return Calculator.create(valueAsString).multiply(10000).getValue().longValue();
    } catch (Exception e) {
      BizException.fail(ApiResponseCode.PARA_ERR, "错误的数据类型");
    }
    return null;
  }
}
