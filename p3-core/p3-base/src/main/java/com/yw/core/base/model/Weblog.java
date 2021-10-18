package com.yw.core.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Administrator
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "web日志")
public class Weblog implements Serializable {
    @ApiModelProperty(value = "接口描述")
    private String description;
    @ApiModelProperty(value = "当前用户名称")
    private String username;
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "持续时间")
    private Integer spendTime;
    @ApiModelProperty(value = "父路径")
    private String basePath;
    @ApiModelProperty(value = "URL")
    private String url;
    @ApiModelProperty(value = "URI")
    private String uri;
    @ApiModelProperty(value = "方法名")
    private String method;
    @ApiModelProperty(value = "IP地址")
    private String ip;
    @ApiModelProperty(value = "参数")
    private Object parameter;
    @ApiModelProperty(value = "返回值")
    private Object result;

}