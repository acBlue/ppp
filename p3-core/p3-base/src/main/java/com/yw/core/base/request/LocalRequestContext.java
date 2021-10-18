package com.yw.core.base.request;

/**
 * 请求上下文信息
 */
public class LocalRequestContext {

    private LocalRequestContext() {
    }

    /**
     * 请求来源渠道ID
     */
    private static final ThreadLocal<String> REQUEST_CHANNEL_ID = new ThreadLocal<>();

    /**
     * 请求的租户ID
     */
    private static final ThreadLocal<Long> REQUEST_TENANT_ID = new ThreadLocal<>();
    /**
     * 设置渠道ID
     */
    public static void setChannelId(String channelId) {
        REQUEST_CHANNEL_ID.set(channelId);
    }

    /**
     * 获取渠道ID
     */
    public static String getChannelId() {
        return REQUEST_CHANNEL_ID.get();
    }


    /**
     * 获取租户ID
     */
    public static Long getTenantId() {
        return REQUEST_TENANT_ID.get();
    }

    /**
     * 设置租户ID
     */
    public static void setTenantId(Long tenantId) {
        REQUEST_TENANT_ID.set(tenantId);
    }
}
