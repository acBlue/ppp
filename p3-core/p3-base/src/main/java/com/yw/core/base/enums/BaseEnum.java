package com.yw.core.base.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = BaseEnumSerializer.class)
public interface BaseEnum<E extends Enum<?>, T> {

	/**
	 * 获取编码
	 * @return
	 */
	T getCode();

	/**
	 * 文字描述
	 * @return
	 */
    String getDesc();

	/**
	 * 枚举类型
	 * @return
	 */
	String getName();
}
