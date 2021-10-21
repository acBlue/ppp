package com.yw.core.web.controller;

import com.yw.core.base.enums.ResultCode;
import com.yw.core.base.exception.BusinessException;
import com.yw.core.base.model.ResponseData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhangyaowen
 * @date 2021/10/19 11:43 下午
 */
@RestControllerAdvice
public class ExceptionController extends BaseRestfulController{

    @ExceptionHandler({BusinessException.class})
    public ResponseData<String> handleException(BusinessException exception){
        return ResponseData.builder(exception.getMessage(),ResultCode.FAIL);
    }
}
