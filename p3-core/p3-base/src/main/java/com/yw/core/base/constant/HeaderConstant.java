package com.yw.core.base.constant;


public abstract class HeaderConstant {

    private HeaderConstant(){}

    public static final int HTTP_SUCCESS_CODE = 200;

    // 客户端设备ID
    public static final String CLIENT_ID = "client-id";

    // 客户端类型（参考常量类：ClientTypeConstants）
    public static final String CLIENT_TYPE = "client-type";

    // 客户端渠道ID（参考常量类：ChannelIdConstants）
    public static final String CHANNEL_ID = "channel-id";

    // 客户租户ID
    public static final String TENANT_ID = "tenant-id";

    // 客户端详情(系统类型，系统版本等)
    public static final String CLIENT_AGENT = "client-agent";

    // 请求token
    public static final String TOKEN = "token";

    // 版本号
    public static final String VERSION = "version";

    //屏幕分辨率
    public static final String SCREEN = "screen";

    // 签名
    public static final String SIGN = "sign";

    public static final String UTF8_ENCODE = "UTF-8";

    public static final String CONTENT_TYPE = "Content-Type";

    public static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";

    // 语言
    public static final String LANG = "lang";


    // 用户ID
    public static final String USER_ID = "userId";
    // 用户名
    public static final String USER_NAME = "userName";
    // 公司ID
    public static final String COMPANY_ID = "companyId";
    // 门店ID集
    public static final String SHOP_IDS = "shopIds";
    // 组织ID
    public static final String ORG_ID = "orgId";


    /**
     * 客户端类型
     */
    public static class ClientType{

         //运营后台
        public static final String BACKEND = "1";

        //骑手APP
        public static final String DELIVERY_APP = "3";

        //门店APP
        public static final String SHOP_APP = "4";

        //商户APP
        public static final String MERCHANT_APP = "5";

        //门店POS
        public static final String POS_APP = "6";

        //WAP商城(微商城)
        public static final String WAP = "10";

        //用户端小程序
        public static final String RETAIL_APPLET = "11";

        //新零售APP
        public static final String RETAIL_APP = "12";

        //新零售微商城(新版小程序共用)
        public static final String RETAIL_H5 = "14";
    }

}
