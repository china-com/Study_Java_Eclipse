package com.sayschj.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

//���student������ɾ�Ĳ���
public class DMLTest {
	@Test
	public void testInsert() throws Exception {
		// DML ��ɾ�Ľ���ֻ��SQL��䲻ͬ
		String sql = "INSERT INTO student(name,age) VALUES('�Ƿ�',38)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydemo", "root", "admin");
		Statement st = conn.createStatement();
		int rows = st.executeUpdate(sql);
		System.out.println("�ɹ�����:"+rows);
		st.close();
		conn.close();
	}
}