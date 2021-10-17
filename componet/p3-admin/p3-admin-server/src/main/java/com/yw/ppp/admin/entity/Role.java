package com.yw.ppp.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;


@Data
@EqualsAndHashCode
@ToString
@TableName("ROLE")
@ApiModel(value = "用户角色")
public class Role implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "角色ID")
    private Long id;

    @TableField(value = "code")

    @ApiModelProperty(value = "角色编码")
    private String code;

    @TableField(value = "name")
    @ApiModelProperty(value = "角色名称")
    private String name;

    @TableField(value = "islock")
    @ApiModelProperty(value = "是否锁定")
    private Boolean islock;

    @TableField(value = "desc")
    @ApiModelProperty(value = "角色描述")
    private String desc;

}
