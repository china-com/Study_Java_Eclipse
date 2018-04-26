package com.sayschj.miniprojects.webcalculator;

//提供判断输入框内容是否为空的方法
public class StringUtils {
	private StringUtils() {}//私有化构造器
	//提供一个静态方法供CalServlet直接调用
	public static boolean hasLength(String value) {
		return value != null && !"".equals(value.trim());
	}
}
