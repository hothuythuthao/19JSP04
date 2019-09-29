package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	//--Cach 1:
//	public static Connection getMyConnection() throws SQLException	{
//		String hostName = "localhost";
//		String dbName = "demo";
//		String userName = "root";
//		String password = "D3ks04I123";
//		return getMyConnection(hostName, dbName, userName, password);
//	}
//	
//	public static Connection getMyConnection(String hostName, String dbName, String userName, String password) throws SQLException	{
//		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
//		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
//		return conn;
//	}
	
	//--Cach 2:
	
	public static Connection getMyConnection() throws SQLException	{
		String hostName = "localhost";
		String dbName = "demo";
		String userName = "root";
		String password = "D3ks04I123";
		
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}
