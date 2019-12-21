package demo.Connect;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnect {
	public static void main(String[] args) {
		try {
			Connection conn = demo.Connect.ConnectionUtils.getMyConnection();
			System.out.println("Connected : " + conn);
		} catch (SQLException e) {
			System.out.println("--Error is : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("--Error is : " + e);
		}
	}
}
