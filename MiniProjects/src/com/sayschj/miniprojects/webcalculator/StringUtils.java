package com.sayschj.miniprojects.webcalculator;

//�ṩ�ж�����������Ƿ�Ϊ�յķ���
public class StringUtils {
	private StringUtils() {}//˽�л�������
	//�ṩһ����̬������CalServletֱ�ӵ���
	public static boolean hasLength(String value) {
		return value != null && !"".equals(value.trim());
	}
}
