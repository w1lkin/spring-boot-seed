package com.welkin.springbootseed.common.exception;

import com.welkin.springbootseed.common.ApiResponseCode;

public class BizException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private Integer code = null;
  private String msg = null;

  public BizException(Integer code, String msg) {
    super(msg);
    this.code = code;
    this.msg = msg;
  }

  public BizException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * 参数错误异常。
   *
   * @param msg
   * @return
   */
  public static void ParaException(String msg) {
    throw new BizException(ApiResponseCode.PARA_ERR.get(), msg);
  }

  /**
   * 抛出超出参数请允许我范围异常。
   *
   * @param msg
   * @return
   */
  public static void ParaOutRangeException(String msg) {
    throw new BizException(ApiResponseCode.PARA_ERR.get(), msg);
  }

  /**
   * 主动抛出异常。
   *
   * @param code
   * @param msg null时则取枚举name,否则取msg消息。
   */
  public static void fail(ApiResponseCode code, String msg) {
    String message = msg == null ? code.getName() : msg;
    throw new BizException(code.get(), message);
  }

  /**
   * 如果对象为null，
   *
   * @param o
   */
  public static void isNull(Object o) {
    if (o == null || o.equals("")) {
      throw new BizException(ApiResponseCode.PARA_MISSING_ERR.get(), "主键不能为空");
    }
  }

  /**
   * 如果对象为null，自定义错误信息
   *
   * @param obj
   * @param msg
   */
  public static void isNull(Object obj, String msg) {
    if (obj == null || obj.equals("")) {
      throw new BizException(ApiResponseCode.PARA_MISSING_ERR.get(), msg);
    }
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
