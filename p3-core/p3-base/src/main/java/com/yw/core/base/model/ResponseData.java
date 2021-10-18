package com.yw.core.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yw.core.base.enums.ResultCode;
import com.yw.core.base.enums.ResultEnum;
import com.yw.core.base.util.MessageUtils;
import lombok.*;

import java.io.Serializable;

/**
 *
 * @author Administrator
 * @param <T>
 */

public class ResponseData<T> implements Serializable {


    private T data;

    private String message;

    private Integer code;


    /**
     * 返回成功
     */
    public static <E> ResponseData<E> builder(E data) {
        return new ResponseData<>(data, ResultCode.SUCCESS);
    }

    public static <E> ResponseData<E> builder(ResultEnum<Integer> result) {
        return new ResponseData<>(result);
    }

    public static <E> ResponseData<E> builder(E data, ResultEnum<Integer> result) {
        return new ResponseData<>(data, result);
    }


    public static <E> ResponseData<E> builder(E data, ResultEnum<Integer> result, String message) {
        Integer code = result.getCode();
        if (message == null) {
            if (MessageUtils.isEnable()) {
                message = MessageUtils.getMessage(code.toString(), result.getDesc());
            } else {
                message = result.getDesc();
            }
        }
        return new ResponseData<>(data, code, message);
    }

    public static <E> ResponseData<E> builder(E data, Integer code, String message) {
        return new ResponseData<>(data, code, message);
    }

    public static <E> ResponseData<E> builder(Integer code, String message) {
        return new ResponseData<>(null, code, message);
    }

    /**
     * <p>Title: 构造方法1</p>
     * <p>Description:无参 </p>
     */
    public ResponseData() {
        this(ResultCode.SUCCESS);
    }

    /**
     * 构造方法2
     */
    public ResponseData(ResultEnum<Integer> result) {
        this(null, result);
    }

    public ResponseData(ResultEnum<Integer> result, Object[] args) {
        this(null, result, args);
    }

    /**
     * 构造方法3
     */
    private ResponseData(T data, ResultEnum<Integer> result) {
        this(data, result.getCode(), MessageUtils.isEnable() ? MessageUtils.getMessage(result.getCode().toString(), result.getDesc()) : result.getDesc());
    }

    private ResponseData(T data, ResultEnum<Integer> result, Object[] args) {
        this(data, result.getCode(), MessageUtils.isEnable() ? MessageUtils.getMessage(result.getCode().toString(), args, result.getDesc()) : result.getDesc());
    }

    /**
     * 构造方法4
     */
    private ResponseData(T data, Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
    }



    /**
     * 判断是否成功
     */
    @JsonIgnore
    public boolean isSuccess() {
        return ResultCode.SUCCESS.getCode().equals(this.code);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setResult(ResultEnum<Integer> result) {
        this.code = result.getCode();
        this.message = result.getDesc();
    }

    public void setResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
