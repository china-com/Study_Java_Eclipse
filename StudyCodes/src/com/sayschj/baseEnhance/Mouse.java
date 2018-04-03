package com.sayschj.baseEnhance;

//遵循USB规范的鼠标
public class Mouse implements IUSB{
	@Override
	public void swapData() {
		// TODO Auto-generated method stub
		System.out.println("鼠标在移动...");
	}
}
