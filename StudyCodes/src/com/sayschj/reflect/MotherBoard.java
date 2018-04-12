package com.sayschj.reflect;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MotherBoard {
	private static Properties p=new Properties();
	//�洢��װ�����еĲ��
	private static Map<String,IUSB> plugins=new HashMap<>();
	//�������ļ����ھ�̬���������ɳ�ʼ��
	static {
		//������������ڼ���������Դ
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		//Ĭ�ϻ��classpath��·��ȥѰ��
		InputStream inStream=loader.getResourceAsStream("plugins.properties");
		
		try {
			p.load(inStream);
			//��ʼ��
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private static void init() throws Exception {
		// TODO Auto-generated method stub
		Set<Object> keys=p.keySet();
		for(Object key:keys) {
			String name=(String)key;//��ȡkey
			String className=p.getProperty(name);
			//ʹ�÷��䴴������֤���ڹ����޲���������
			Object obj=Class.forName(className).newInstance();
			//�жϵ�ǰ�����Ƿ�ʵ����IUSB�淶
			if (!(obj instanceof IUSB)) {
				throw new RuntimeException(name+",û����ѭUSB�淶"); 
			}
			plugins.put(name, (IUSB)obj);
		}
	}
	
	//�������ϵĲ����������
	public static void work() {
		//��������װ�������ϵ�ÿһ�������������ÿһ������Ĺ�������
		for (IUSB plugin : plugins.values()) {
			plugin.swapData();
		}
	}
}