package com.yw.ppp.uc.controller;

import com.yw.core.base.enums.ResultCode;
import com.yw.core.base.enums.ResultEnum;
import com.yw.core.base.model.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    public ResponseData<String> index(){
        return ResponseData.builder(ResultCode.SUCCESS);
    }
}
