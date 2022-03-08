package com.yw.ppp.uc.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yw.core.base.enums.ResultCode;
import com.yw.core.base.model.PageView;
import com.yw.core.base.model.ResponseData;
import com.yw.core.web.controller.BaseRestfulController;
import com.yw.ppp.uc.controller.admin.vo.param.UserQueryVO;
import com.yw.ppp.uc.controller.admin.vo.param.UserRegeditVO;
import com.yw.ppp.uc.entity.User;
import com.yw.ppp.uc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/uc/admin/user")
@Api(value = "User")
public class UserController extends BaseRestfulController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "注册")
    @PostMapping("/regedit")
    public ResponseData<String> regedit(@RequestBody UserRegeditVO vo) {


        return ResponseData.builder(ResultCode.SUCCESS);
    }


    public ResponseData<PageView> findAll(UserQueryVO queryVO)   {


         Page<User> userPage =  new Page<>(queryVO.getPageNum(),queryVO.getPageSize());
         LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
         queryWrapper.eq(StringUtils.isNotBlank(queryVO.getUserName()),User::getAccount,queryVO.getUserName());

         userPage  = userService
                   .page(userPage,queryWrapper);

         PageView pageView = new PageView(userPage.getRecords());

        return ResponseData.builder(pageView);
    }

}
