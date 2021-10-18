package com.yw.ppp.uc.entity;

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
@TableName("menu")
@ApiModel(value = "菜单")
public class Menu implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    @TableField(value = "name")
    @ApiModelProperty(value = "菜单名称", required = true)
    private String name;

    @TableField(value = "url")
    @ApiModelProperty(value = "URL地址")
    private String url;

    @TableField(value = "parent_id")
    @ApiModelProperty(value = "父菜单ID")
    private Long parentId;

    @TableField(value = "seq")
    @ApiModelProperty(value = "菜单排序序号")
    private Integer seq;

}
