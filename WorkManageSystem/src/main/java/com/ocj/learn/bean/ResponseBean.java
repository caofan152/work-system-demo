package com.ocj.learn.bean;

/**
 * 返回实体
 * @author LuoAnDong
 * @sine 2018年8月5日 上午11:22:34
 * @param <T>
 */
public class ResponseBean<T> {
	
    private int code;
    private String message;
    private  T data;

    public int getCode() {
        return code;
    }

    public ResponseBean() {
    }

    public ResponseBean<T> setCode(ResultCodeEnum resultCode) {
        this.code = resultCode.getCode() ;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseBean<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseBean<T> setData(T data) {
        this.data = data;
        return this;
    }
}