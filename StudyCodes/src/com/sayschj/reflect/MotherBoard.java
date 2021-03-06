package com.sayschj.reflect;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MotherBoard {
	private static Properties p=new Properties();
	//存储安装的所有的插件
	private static Map<String,IUSB> plugins=new HashMap<>();
	//将配置文件放在静态代码块中完成初始化
	static {
		//类加载器，用于加载配置资源
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		//默认会从classpath的路径去寻找
		InputStream inStream=loader.getResourceAsStream("plugins.properties");
		
		try {
			p.load(inStream);
			//初始化
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
			String name=(String)key;//获取key
			String className=p.getProperty(name);
			//使用反射创建，保证存在公共无参数构造器
			Object obj=Class.forName(className).newInstance();
			//判断当前对象是否实现了IUSB规范
			if (!(obj instanceof IUSB)) {
				throw new RuntimeException(name+",没有遵循USB规范"); 
			}
			plugins.put(name, (IUSB)obj);
		}
	}
	
	//让主板上的插件工作起来
	public static void work() {
		//迭代出安装在主板上的每一个插件，并调用每一个插件的工作方法
		for (IUSB plugin : plugins.values()) {
			plugin.swapData();
		}
	}
}
