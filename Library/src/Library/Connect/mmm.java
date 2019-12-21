package Library.Connect;

import java.sql.Connection;
import java.sql.SQLException;

public class mmm {

	public static void main(String[] args) {
		try {
			Connection conn = Library.Connect.ConnectionUtils.getMyConnection();
			System.out.println(conn);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error is: " + e);
		}
	}

}
