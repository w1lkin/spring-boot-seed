package com.welkin.springbootseed.common.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/** 加减乘除工具类 */
public class Calculator {

  private BigDecimal value;

  private Calculator(String operand) {
    this.value = new BigDecimal(operand);
  }

  public static Calculator create(String operand) {
    return new Calculator(operand);
  }

  public static Calculator create(BigDecimal operand) {
    return new Calculator(operand.toString());
  }

  public static Calculator create(int operand) {
    return new Calculator(String.valueOf(operand));
  }

  public static Calculator create(short operand) {
    return new Calculator(String.valueOf(operand));
  }

  public static Calculator create(long operand) {
    return new Calculator(String.valueOf(operand));
  }

  public static Calculator create(float operand) {
    return new Calculator(String.valueOf(operand));
  }

  public static Calculator create(double operand) {
    return new Calculator(String.valueOf(operand));
  }

  public Calculator multiply(String operand) {
    this.value = this.value.multiply(new BigDecimal(operand));
    return this;
  }

  public Calculator multiply(BigDecimal operand) {
    this.value = this.value.multiply(new BigDecimal(operand.toString()));
    return this;
  }

  public Calculator multiply(int operand) {
    this.value = this.value.multiply(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator multiply(short operand) {
    this.value = this.value.multiply(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator multiply(long operand) {
    this.value = this.value.multiply(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator multiply(float operand) {
    this.value = this.value.multiply(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator multiply(double operand) {
    this.value = this.value.multiply(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator divide(String operand) {
    this.value = this.value.divide(new BigDecimal(operand));
    return this;
  }

  public Calculator divide(BigDecimal operand) {
    this.value = this.value.divide(new BigDecimal(operand.toString()));
    return this;
  }

  public Calculator divide(int operand) {
    this.value = this.value.divide(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator divide(short operand) {
    this.value = this.value.divide(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator divide(long operand) {
    this.value = this.value.divide(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator divide(float operand) {
    this.value = this.value.divide(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator divide(double operand) {
    this.value = this.value.divide(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator divide(double operand, int scale, RoundingMode mode) {
    this.value = this.value.divide(new BigDecimal(String.valueOf(operand)), scale, mode);
    return this;
  }

  public Calculator add(String operand) {
    this.value = this.value.add(new BigDecimal(operand));
    return this;
  }

  public Calculator add(BigDecimal operand) {
    this.value = this.value.add(new BigDecimal(operand.toString()));
    return this;
  }

  public Calculator add(int operand) {
    this.value = this.value.add(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator add(short operand) {
    this.value = this.value.add(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator add(long operand) {
    this.value = this.value.add(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator add(float operand) {
    this.value = this.value.add(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator add(double operand) {
    this.value = this.value.add(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator subtract(String operand) {
    this.value = this.value.subtract(new BigDecimal(operand));
    return this;
  }

  public Calculator subtract(BigDecimal operand) {
    this.value = this.value.subtract(new BigDecimal(operand.toString()));
    return this;
  }

  public Calculator subtract(int operand) {
    this.value = this.value.subtract(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator subtract(short operand) {
    this.value = this.value.subtract(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator subtract(long operand) {
    this.value = this.value.subtract(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator subtract(float operand) {
    this.value = this.value.subtract(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator subtract(double operand) {
    this.value = this.value.subtract(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator remainder(String operand) {
    this.value = this.value.remainder(new BigDecimal(operand));
    return this;
  }

  public Calculator remainder(BigDecimal operand) {
    this.value = this.value.remainder(new BigDecimal(operand.toString()));
    return this;
  }

  public Calculator remainder(int operand) {
    this.value = this.value.remainder(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator remainder(short operand) {
    this.value = this.value.remainder(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator remainder(long operand) {
    this.value = this.value.remainder(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator remainder(float operand) {
    this.value = this.value.remainder(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator remainder(double operand) {
    this.value = this.value.remainder(new BigDecimal(String.valueOf(operand)));
    return this;
  }

  public Calculator round(int precision) {
    this.value.round(new MathContext(precision));
    return this;
  }

  public Calculator round(int precision, RoundingMode roundingMode) {
    this.value.round(new MathContext(precision, roundingMode));
    return this;
  }

  public Calculator scale(int scale) {
    this.value.setScale(scale);
    return this;
  }

  public Calculator scale(int scale, RoundingMode roundingMode) {
    this.value.setScale(scale, roundingMode);
    return this;
  }

  public BigDecimal getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
