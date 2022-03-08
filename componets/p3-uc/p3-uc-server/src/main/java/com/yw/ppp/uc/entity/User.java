package com.yw.ppp.uc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("USER")
@Data
@ToString
@EqualsAndHashCode
@ApiModel(value = "用户实体")
public class User implements Serializable {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(name = "id", value = "用户ID", allowEmptyValue = false, dataType = "Long")
    private Long id;

    @TableField("name")
    @ApiModelProperty(name = "name", value = "用户名", allowEmptyValue = false, allowableValues = "姓名长度最多20个字符")
    private String name;

    @TableField("account")
    @ApiModelProperty(name = "account", value = "用户账号", allowEmptyValue = false, allowableValues = "用户账号长度最多20个字符")
    private String account;

    @TableField("password")
    @ApiModelProperty(name = "password", value = "密码", allowEmptyValue = false, allowableValues = "密码最少8个字符，最长30个字符，MD5加密）")
    private String password;

    @TableField("createtime")
    @ApiModelProperty(name = "createTime", value = "创建时间", dataType = "LocalDate")
    private LocalDateTime createTime;

    @TableField("lastlogin")
    @ApiModelProperty(name = "lastLogin", value = "最后登录时间", dataType = "LocalDate")
    private LocalDateTime lastLogin;

    @TableField("active")
    @ApiModelProperty(name = "active", value = "账户是否锁定", dataType = "Boolean")
    private Boolean active;



}
