package com.sayschj.JDBCDemo;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

//使用jdbc创建一张表
public class DDLTest {
	@Test
	public void test1() throws Exception {
		String sql = "CREATE TABLE student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),age INT)";
		// 方式1、手动加载注册驱动
		// 1.加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydemo", "root", "admin");
		/*
		 * //方式2、从JDK1.6开始，支持自动架子啊祖册驱动 //直接创建连接即可 Connection
		 * conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studydemo",
		 * "root", "admin");
		 */
		// 3.创建语句对象
		Statement st = conn.createStatement();
		// 4.执行SQL
		int rows = st.executeUpdate(sql);
		System.out.println(rows);
		// 5.释放资源
		st.close();
		conn.close();
	}

	@Test
	public void testHandleException() {
		String sql = "CREATE TABLE student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),age INT)";
		// 声明资源对象
		Connection conn = null;
		Statement st = null;
		try {
			// 1、加载注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2、获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydemo", "root", "admin");
			// 3、创建语句对象
			st = conn.createStatement();
			// 4、执行SQL
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5、释放资源
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testAutoHandleByJava7(){
		String sql = "CREATE TABLE student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),age INT)";
		try {
			// 1.加载注册驱动
			//注册驱动要先于其他几步，但又不能放在try()的里面，只能自己创建一个try
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try (
				// 2.获取连接对象
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydemo", "root", "admin");
				// 3.创建语句对象
				Statement st = conn.createStatement();) {
			// 4、执行SQL
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
