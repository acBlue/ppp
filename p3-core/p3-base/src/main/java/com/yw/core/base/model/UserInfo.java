package com.yw.core.base.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserInfo implements Serializable {

    private String userId;

    private String userName;

    private String rentId;
}
