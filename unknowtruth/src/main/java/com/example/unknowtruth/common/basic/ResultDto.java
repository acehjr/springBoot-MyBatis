package com.example.unknowtruth.common.basic;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class ResultDto<T> implements Serializable {
    private static final long serialVersionUID = -1L;
    private Integer code;
    private String msg;
    private T data;

    public ResultDto() {
    }

    public ResultDto(Integer code) {
        this(code, "", null);
    }

    public ResultDto(Integer code, T data) {
        this(code, "", data);
    }

    public ResultDto(Integer code, String msg) {
        this(code, msg, null);
    }

    public ResultDto(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
