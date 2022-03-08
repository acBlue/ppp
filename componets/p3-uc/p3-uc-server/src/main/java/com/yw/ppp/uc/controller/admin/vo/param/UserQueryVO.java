package com.yw.ppp.uc.controller.admin.vo.param;



import com.yw.core.base.model.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户查询VO")
public class UserQueryVO extends PageParam implements Serializable {

    @ApiModelProperty("姓氏")
    private String fristName;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("性别")
    private Integer sex;

}
