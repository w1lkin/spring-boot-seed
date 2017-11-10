package com.welkin.springbootseed.model.enums;

public enum Authority {
  PUBLIC(1, "公开"),
  PRIVATE(2, "私有");

  private int code;

  private String value;

  Authority(int code, String value) {
    this.code = code;
    this.value = value;
  }
}
