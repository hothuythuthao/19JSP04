package Library.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		String hostName = "localhost";
		String dbName = "mylibrary";
		String userName = "root";
		String password = "D3ks04I123";
		
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection connnection = DriverManager.getConnection(connectionURL, userName, password);
		return connnection;
	}
}
