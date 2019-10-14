package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public class StudentController {

	public static void AddNewStudent(Student student) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "INSERT INTO Student(student_name, student_age) VALUES(?, ?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, student.getStudentName());
		prepareStatement.setInt(2, student.getStudentAge());
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
	}

	public static Student getStudentByID(int studentID) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "SELECT student_id, student_name, student_age FROM Student WHERE student_id=?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, studentID);
		ResultSet rs = prepareStatement.executeQuery();
		if (rs.next()) {
			Student student = new Student(rs.getInt("student_id"), rs.getString("student_name"),
					rs.getInt("student_age"));
			rs.close();
			prepareStatement.close();
			connection.close();
			return student;
		} else {
			rs.close();
			prepareStatement.close();
			connection.close();
			return null;
		}
	}

	public static Student getStudentByName(String name) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "SELECT student_id, student_name, student_age FROM Student WHERE student_name LIKE ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, name);
		ResultSet rs = prepareStatement.executeQuery();
		if (rs.next()) {
			Student student = new Student(rs.getInt("student_id"), rs.getString("student_name"),
					rs.getInt("student_age"));
			rs.close();
			prepareStatement.close();
			connection.close();
			return student;
		} else {
			rs.close();
			prepareStatement.close();
			connection.close();
			return null;
		}
	}

	public static void DeleteStudentByID(int studentID) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "DELETE FROM Student WHERE student_id = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, studentID);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
	}

	public static ArrayList<Student> getAllStudent() throws SQLException {
		ArrayList<Student> listStudent = new ArrayList<>();
		String sql = "SELECT student_id, student_name, student_age FROM Student";
		Connection connection = utils.ConnectDB.getMyConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery(sql);
		while (rs.next()) {
			Student student = new Student(rs.getInt("student_id"), rs.getString("student_name"),
					rs.getInt("student_age"));
			listStudent.add(student);
		}
		rs.close();
		prepareStatement.close();
		connection.close();
		return listStudent;
	}
}
