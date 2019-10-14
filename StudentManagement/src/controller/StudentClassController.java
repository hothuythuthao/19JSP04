package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.StudentClass;

public class StudentClassController {
	public static void AddNewStudentClass(StudentClass studentClass) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "INSERT INTO Student_Class(student_id, class_id) VALUES(?, ?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, studentClass.getStudent_id());
		prepareStatement.setInt(2, studentClass.getClass_id());
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
	}

	public static void SearchStudent(int studentID, String studentName, int studentAge) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "SELECT student.student_id, student.student_name, student.student_age, class.class_name "
				+ "FROM student_class " + "INNER JOIN student ON student_class.student_id = student.student_id "
				+ "INNER JOIN class ON student_class.class_id = class.class_id "
				+ "WHERE student.student_id = ? OR student_name LIKE ? OR student_age = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, studentID);
		prepareStatement.setString(2, studentName);
		prepareStatement.setInt(3, studentAge);
		prepareStatement.execute();
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.printf("%-15d", rs.getInt("student_id"));
			System.out.printf("%-25s", rs.getString("student_name"));
			System.out.printf("%-20d", rs.getInt("student_age"));
			System.out.printf("%-20s", rs.getString("class_name"));
			System.out.println();
		}
		prepareStatement.close();
		connection.close();
	}

	public static void getAllStudentClass() {
		try {
			Connection connection = utils.ConnectDB.getMyConnection();
			String sql = "SELECT student.student_id, student.student_name, student.student_age, class.class_name "
					+ "FROM student_class " + "INNER JOIN student ON student_class.student_id = student.student_id "
					+ "INNER JOIN class ON student_class.class_id = class.class_id ";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			System.out.println(
					"----------------------------------- STUDENTS INFORMATION -----------------------------------");
			System.out.printf("%-14s %-24s %-19s %-19s", "Student ID", "Student Name", "Student Age", "Class Name");
			System.out.println();
			while (rs.next()) {
				System.out.printf("%-15d", rs.getInt("student_id"));
				System.out.printf("%-25s", rs.getString("student_name"));
				System.out.printf("%-20d", rs.getInt("student_age"));
				System.out.printf("%-20s", rs.getString("class_name"));
				System.out.println();
			}
			prepareStatement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("The error is " + e);
		}

	}

}
