package com.sayschj.miniprojects;

public class StringUtils {
	private StringUtils() {
	}

	public static boolean hasLength(String value) {
		return value != null && !"".equals(value.trim());
	}
}
