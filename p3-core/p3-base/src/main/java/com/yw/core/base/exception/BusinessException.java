package com.yw.core.base.exception;

import com.yw.core.base.enums.ResultCode;

/**
 * @author Administrator
 */
public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BusinessException() {
        super();
    }

    public BusinessException(ResultCode channelIdError) {
        super();
    }
}
