package com.largehat.common.im.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 *
 * 枚举工具
 *
 *
 */
@Slf4j
public final class EnumUtil {

    private EnumUtil() {
    }

    /**
	 * 根据枚举index返回枚举元素，index从0开始
	 *
	 * @param <T>
	 *            枚举类型
	 * @param values
	 *            枚举元素输注
	 * @param index
	 *            从0开始的index
	 * @return 枚举元素
	 */
	public static <T extends Enum<T>> T valueOf(List<T> values, int index) {
		T value;
		try {
			value = values.get(index);
		} catch (Exception e) {
			String typeName = "unknown";
			if (values != null) {
				for (T enu : values) {
					if (enu != null) {
						typeName = enu.getClass().getName();
						break;
					}
				}
			}
			log.error(String.format("从枚举中取元素时错误 type=%1$s index=%2$d error=%3$s", typeName, index, e.getMessage()));
			return null;
		}
		return value;
	}

}
