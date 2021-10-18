package com.yw.ppp.uc.controller.admin;

import com.yw.core.base.enums.ResultCode;
import com.yw.core.base.model.ResponseData;
import com.yw.core.web.controller.BaseRestfulController;
import com.yw.ppp.uc.controller.admin.vo.param.UserRegeditVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uc/admin/user")
@Api(value = "User")
public class UserController extends BaseRestfulController {


    @ApiOperation(value = "org.springframework.web.bind.annotation.RestController")
    @PostMapping("/regedit")
    public ResponseData<String> regedit(@RequestBody UserRegeditVO vo){
        return ResponseData.builder(ResultCode.SUCCESS);
    }



}
