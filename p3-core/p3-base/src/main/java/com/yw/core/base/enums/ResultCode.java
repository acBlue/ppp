package com.yw.core.base.enums;

/**
 * ClassName: ResultCode
 * @author guocp
 * Description 执行结果code枚举
 * <p>0: 执行成功 ,
 * <p>-1: 执行失败 ,
 * <p>1000到1500之内为系统错误
 * <p>1500以上为业务错误
 */
public enum ResultCode implements ResultEnum<Integer> {
    /**
     * 0:执行成功
     */
    SUCCESS(0, "操作成功"),

    /**
     * -1:执行失败
     */
    FAIL(-1, "操作失败"),

    /**
     * 1000:业务异常
     */
    BUSINESS_ERROR(1000, "业务异常"),

    /**
     * 1001:非法请求
     */
    UNLAW_REQUEST(1001, "非法请求"),

    /**
     * 1002:未登录或token失效
     */
    NOT_LOGIN(1002, "请登录"),

    /**
     * 登录已过期
     */
    LOGIN_EXPIRED(1002, "登录已过期"),

    /**
     * 1003:图片上传失败
     */
    UPLOAD_FAIL(1003, "文件上传失败"),

    /**
     * 1004:用户调用次数超限
     */
    USER_CALL_LIMITED(1004, "用户调用次数超限"),

    /**
     * 1005:会话调用次数超限
     */
    SESSION_CALL_LIMITED(1005, "会话调用次数超限"),

    /**
     * 1006:应用调用次数超限
     */
    APP_CALL_LIMITED(1006, "应用调用次数超限"),

    /**
     * 1007:应用调用频率超限
     */
    APP_CALL_EXCEEDS_LIMITED_FREQUENCY(1007, "应用调用频率超限"),

    /**
     * 1008:服务不可用
     */
    SERVICE_CURRENTLY_UNAVAILABLE(1008, "服务不可用"),

    /**
     * 1009:远程服务出错
     */
    REMOTE_SERVICE_ERROR(1009, "服务调用异常"),

    /**
     * 1010:缺少方法名参数
     */
    MISSING_METHOD(1010, "缺少方法名参数"),

    /**
     * 1011:不存在的方法名
     */
    INVALID_METHOD(1011, "不存在的方法名"),
    /**
     * 1012:非法数据格式
     */
    INVALID_FORMAT(1012, "非法数据格式"),
    /**
     * 1013:缺少签名参数
     */
    MISSING_SIGNATURE(1013, "缺少签名参数"),
    /**
     * 1014:非法签名
     */
    INVALID_SIGNATURE(1014, "非法签名"),
    /**
     * 1015:缺少版本参数
     */
    MISSING_VERSION(1015, "缺少版本参数"),
    /**
     * 1016:非法的版本参数
     */
    INVALID_VERSION(1016, "非法的版本参数"),
    /**
     * 1017:不支持的版本号
     */
    UNSUPPORTED_VERSION(1017, "不支持的版本号"),
    /**
     * 1018:缺少必选参数
     */
    MISSING_REQUIRED_ARGUMENTS(1018, "缺少必选参数"),
    /**
     * 1019:非法的参数
     */
    INVALID_ARGUMENTS(1019, "非法的参数"),
    /**
     * 1020:请求被禁止
     */
    FORBIDDEN_REQUEST(1020, "请求被禁止"),
    /**
     * 1021:参数错误
     */
    PARAMETER_ERROR(1021, "参数错误"),

    /**
     * 1022:没有操作权限
     */
    NOT_AUTHORITY(1022, "没有操作权限"),

    /**
     * 1023:请求无数据
     */
    DATA_NOT_EXIST(1023, "请求无数据"),

    /**
     * 1024:请求无数据
     */
    LOGIN_ERROR(1024, "登入失败，请检查用户或密码"),

    /**
     * 1025:登入失效，请重新登入
     */
    LOGIN_INVALID(1025, "登入失效，请重新登入"),

    /**
     * 1026:重复请求
     */
    REQUEST_DUPLICATE(1026, "重复请求"),

    /**
     * 1027:网络超时，请重试
     */
    REQUEST_TIMEOUT(1027, "网络超时，请重试"),

    /**
     * 1028:渠道ID错误
     */
    CHANNEL_ID_ERROR(1028, "渠道ID错误"),

    /**
     * 1029:没有操作权限
     */
    NOT_DATA_AUTHORITY(1029, "没有数据权限"),

    /**
     * 1030:服务器超时，请稍后重试
     */
    REQUEST_SERVER_TIMEOUT(1030, "服务器超时，请稍后重试"),

    /**
     * 缺少租户上下文信息
     */
    MISSING_TENANT_CONTEXT(1031, "未找到商户上下文信息"),
    GENERATE_CAPTCHA_FAILURE(1032, "验证码图片生成异常"),
    RESOLVE_USER_NAME_FAILURE(1033, "获取用户名解析编码异常");


    private Integer code;
    private String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    /**
     * 根据code值换取中文提示信息
     * @param code 错误码
     */
    public static ResultCode enumValueOf(int code) {
        for (ResultCode codeEnum : ResultCode.values()) {
            if (codeEnum.getCode() == code) {
                return codeEnum;
            }
        }
        return null;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
