package com.chenhongjuan.mavendemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//MySQL���ݿ����ӹ�����
public class MySQLUtils {
	private static Connection connection;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			Class.forName("com.mysql.jdbc.Driver");// �����ֶ�
			String url = "jdbc:mysql://localhost:3306/studydemo";// ���ݿ����ƣ�studydemo,�û�����root�����룺admin
			String user = "root";// �û���
			String password = "admin";// ����
			return DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
}
