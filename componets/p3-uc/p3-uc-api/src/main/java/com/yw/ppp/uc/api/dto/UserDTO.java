package com.yw.ppp.uc.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhangyaowen
 * @date 2021/10/24 12:22 下午
 */

@Data
public class UserDTO implements Serializable {

    @ApiModelProperty(name = "id", value = "用户ID", allowEmptyValue = false, dataType = "Long")
    private Long id;

    @ApiModelProperty(name = "name", value = "用户名", allowEmptyValue = false, allowableValues = "姓名长度最多20个字符")
    private String name;

    @ApiModelProperty(name = "account", value = "用户账号", allowEmptyValue = false, allowableValues = "用户账号长度最多20个字符")
    private String account;

    @ApiModelProperty(name = "password", value = "密码", allowEmptyValue = false, allowableValues = "密码最少8个字符，最长30个字符，MD5加密）")
    private String password;

    @ApiModelProperty(name = "createTime", value = "创建时间", dataType = "LocalDate")
    private LocalDateTime createTime;

    @ApiModelProperty(name = "lastLogin", value = "最后登录时间", dataType = "LocalDate")
    private LocalDateTime lastLogin;

    @NotNull(message = "")
    @ApiModelProperty(name = "active", value = "账户是否锁定", dataType = "Boolean")
    private Boolean active;
}
