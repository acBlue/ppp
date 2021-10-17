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
@TableName("PERMISSION")
@ApiModel(value = "权限", description = "用户权限")
public class Permission implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(name = "id", value = "权限ID", required = true)
    private Long id;
    @TableField(value = "name")
    @ApiModelProperty(name = "name", value = "权限名称", required = true)
    private String name;


    @TableField(value = "type")
    @ApiModelProperty(name = "type", value = "权限类型", required = true)
    private String type;

}
