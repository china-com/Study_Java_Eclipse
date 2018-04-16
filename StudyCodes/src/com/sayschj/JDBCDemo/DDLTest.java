package com.sayschj.JDBCDemo;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

//ʹ��jdbc����һ�ű�
public class DDLTest {
	@Test
	public void test1() throws Exception {
		String sql = "CREATE TABLE student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),age INT)";
		// ��ʽ1���ֶ�����ע������
		// 1.����ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydemo", "root", "admin");
		/*
		 * //��ʽ2����JDK1.6��ʼ��֧���Զ����Ӱ�������� //ֱ�Ӵ������Ӽ��� Connection
		 * conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studydemo",
		 * "root", "admin");
		 */
		// 3.����������
		Statement st = conn.createStatement();
		// 4.ִ��SQL
		int rows = st.executeUpdate(sql);
		System.out.println(rows);
		// 5.�ͷ���Դ
		st.close();
		conn.close();
	}

	@Test
	public void testHandleException() {
		String sql = "CREATE TABLE student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),age INT)";
		// ������Դ����
		Connection conn = null;
		Statement st = null;
		try {
			// 1������ע������
			Class.forName("com.mysql.jdbc.Driver");
			// 2����ȡ���Ӷ���
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydemo", "root", "admin");
			// 3������������
			st = conn.createStatement();
			// 4��ִ��SQL
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5���ͷ���Դ
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
			// 1.����ע������
			//ע������Ҫ�����������������ֲ��ܷ���try()�����棬ֻ���Լ�����һ��try
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try (
				// 2.��ȡ���Ӷ���
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydemo", "root", "admin");
				// 3.����������
				Statement st = conn.createStatement();) {
			// 4��ִ��SQL
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}