package com.sayschj.baseEnhance;

public class MotherBoard {
	public static void install(IUSB e) {
		System.out.println("��װ"+e.getClass().getSimpleName());
		e.swap();
	}
}
