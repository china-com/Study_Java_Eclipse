package com.chenhongjuan.mavendemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//MySQL数据库连接工具类
public class MySQLUtils {
	private static Connection connection;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			Class.forName("com.mysql.jdbc.Driver");// 驱动字段
			String url = "jdbc:mysql://localhost:3306/studydemo";// 数据库名称：studydemo,用户名：root，密码：admin
			String user = "root";// 用户名
			String password = "admin";// 密码
			return DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
}
