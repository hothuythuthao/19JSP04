package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection getMyConnection() throws SQLException {
		String hostName = "localhost";
		String dbName = "StudentManagement";
		String userName = "root";
		String password = "D3ks04I123";

		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}
