package com.welkin.springbootseed.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Result<T> implements Serializable {

    @JsonProperty("Code")
    private int code = ApiResponseCode.SUCCESS.get();

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Data")
    private T data;

    @JsonProperty("ServerTime")
    private String serverTime;

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }


    public Result() {
    }

    public Result(ApiResponseCode code) {
        this(code.get(), code.getName());
    }

    public Result(int code, String message) {
        this(code, message, null);
    }

    public Result(ApiResponseCode code, T data) {
        this(code.get(), code.getName(), data);
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        setServerTime(df.format(new Date()));
    }

    public static <T> Result<T> createSuccess() {
        return createSuccess(null);
    }

    public static <T> Result<T> createSuccess(T t) {
        return createSuccess(null, t);
    }

    public static <T> Result<T> createSuccess(String msg, T t) {
        return new Result<T>(ApiResponseCode.SUCCESS.get(), msg, t);
    }

    public static <T> Result<T> createUnknowFail(int code, String msg) {
        return new Result<T>(code, msg);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
