package com.yw.core.base.enums;


/**
 * ClassName: ResultEnum
 * @author guocp
 * @date 2017年5月2日
 */
public interface ResultEnum<T> {

    T getCode();

    String getDesc();


    default ResultEnum<T> getParent() {
        return null;
    }
}
