package com.yw.core.base.enums;


/**
 * @author Administrator
 */

public enum Enabled implements BaseEnum<Enabled, Integer> {

    /**
     * 不启用
     */
    NO(0, "不启用"),

    /**
     * 启用
     */
    YES(1, "启用");

    /**
     * 编码
     */
    private int code;

    /**
     * 描述
     */
    private String desc;

    Enabled(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getName() {
        return this.name();
    }

    public Enabled enumValueOf(int code) {
        for (Enabled enabled : Enabled.values()) {
            if (enabled.getCode() == code) {
                return enabled;
            }
        }
        return null;
    }
}
