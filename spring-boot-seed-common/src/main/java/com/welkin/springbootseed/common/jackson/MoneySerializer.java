package com.welkin.springbootseed.common.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.welkin.springbootseed.common.util.Calculator;

import java.io.IOException;
import java.math.RoundingMode;

public class MoneySerializer extends JsonSerializer<Long> {
  @Override
  public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException {

    if (value == null || value.equals(0)) return;
    gen.writeString(
        String.valueOf(Calculator.create(value).divide(10000, 4, RoundingMode.HALF_UP)));
  }
}
