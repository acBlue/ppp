package com.yw.ppp.uc.controller.admin.vo.param;



import com.yw.core.base.model.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserQueryVO extends PageParam {

    private String fristName;


    private String userName;


    private Integer sex;


}
