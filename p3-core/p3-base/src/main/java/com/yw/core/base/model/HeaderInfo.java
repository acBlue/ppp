package com.yw.core.base.model;

import lombok.*;

import java.io.Serializable;


@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class HeaderInfo implements Serializable {

    private static final long serialVersionUID = -1037723362471069471L;

    /**
     * 设备ID
     */
    private String clientId;

    /**
     * 客户端类型（1-运营后台,2-小程序，3-骑手APP,4-门店APP）
     */
    private String clientType;

    /**
     * 客户端详情(系统类型，系统版本等)
     */
    private String clientAgent;

    /**
     * 用户token
     */
    private String token;

    /**
     * app版本
     */
    private String version;

    /**
     * 屏幕分辨率
     */
    private String screen;

    /**
     * 签名
     */
    private String sign;

    /**
     * 渠道ID
     */
    private Long channelId;
}
