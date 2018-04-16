package com.sayschj.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

//针对student表做增删改操作
public class DMLTest {
	@Test
	public void testInsert() throws Exception {
		// DML 增删改仅仅只是SQL语句不同
		String sql = "INSERT INTO student(name,age) VALUES('乔峰',38)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydemo", "root", "admin");
		Statement st = conn.createStatement();
		int rows = st.executeUpdate(sql);
		System.out.println("成功操作:"+rows);
		st.close();
		conn.close();
	}
}
