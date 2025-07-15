package com.moandjiezana.toml;

import com.google.gson.ToNumberStrategy;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

class ToNumberStrategyImpl implements ToNumberStrategy {
  static final ToNumberStrategy DOUBLE_INT_OR_LONG = new ToNumberStrategyImpl();

  @Override
  public Number readNumber(JsonReader jsonReader) throws IOException {
    String value = jsonReader.nextString();

    if (value.contains(".") || value.contains("e") || value.contains("E")) {
      return Double.parseDouble(value);
    }

    try {
      return Integer.parseInt(value);
    } catch (Exception e) {
      return Long.parseLong(value);
    }
  }
}
