package mavendemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLUtils {
private static Connection connection;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://211.69.248.136:3306/mysql_java";
			String user = "root";
			String password = "root";
			return DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
}
