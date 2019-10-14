package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DayOff;

public class DayOffController {

	public static void AddNewDayOff(DayOff dayOff) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "INSERT INTO DayOff(day_off, student_id) VALUES(?, ?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setDate(1, dayOff.getDayOff());
		prepareStatement.setInt(2, dayOff.getStudentID());
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
	}

	public static void SearchDayOff(String name, Date date) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "SELECT student_name, day_off FROM dayoff "
				+ "INNER JOIN student ON student.student_id = dayoff.student_id "
				+ "WHERE student_name LIKE ? OR day_off = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, name);
		prepareStatement.setDate(2, date);
		prepareStatement.execute();
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.printf("%-25s", rs.getString("student_name"));
			System.out.printf("%-25s", rs.getDate("day_off"));
			System.out.println();
		}
		prepareStatement.close();
		connection.close();
	}

	public static DayOff getDateOfByDate(Date date) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "SELECT dayoff_id, day_off, student_id FROM DayOff WHERE day_off = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setDate(1, date);
		ResultSet rs = prepareStatement.executeQuery();
		if (rs.next()) {
			DayOff dayOff = new DayOff(rs.getInt("dayoff_id"), rs.getDate("day_off"), rs.getInt("student_id"));
			rs.close();
			prepareStatement.close();
			connection.close();
			return dayOff;
		} else {
			rs.close();
			prepareStatement.close();
			connection.close();
			return null;
		}
	}

	public static void getAllDayOff() {
		try {
			Connection connection = utils.ConnectDB.getMyConnection();
			String sql = "SELECT dayoff.dayoff_id, dayoff.day_off, dayoff.student_id, student.student_name FROM DayOff "
					+ "INNER JOIN student ON dayoff.student_id = student.student_id";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery(sql);
			System.out.println("------------------------------- DAY OFF INFORMATION -------------------------------");
			System.out.printf("%-14s %-24s %-19s %-19s", "Day Off ID", "Day Off", "Student ID", "Student Name");
			System.out.println();
			while (rs.next()) {
				System.out.printf("%-15d", rs.getInt("dayoff_id"));
				System.out.printf("%-25s", rs.getDate("day_off"));
				System.out.printf("%-20d", rs.getInt("student_id"));
				System.out.printf("%-20s", rs.getString("student_name"));
				System.out.println();
			}
			rs.close();
			prepareStatement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}

	}
}
