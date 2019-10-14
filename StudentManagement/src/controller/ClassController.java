package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Class;

public class ClassController {
	public static void AddNewClass(Class clas) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "INSERT INTO Class(class_name) VALUES(?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, clas.getClassName());
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
	}

	public static Class getClassByID(int classID) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "SELECT class_id, class_name, amount FROM Class WHERE class_id=?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, classID);
		ResultSet rs = prepareStatement.executeQuery();
		if (rs.next()) {
			Class clas = new Class(rs.getInt("class_id"), rs.getString("class_name"), rs.getInt("amount"));
			rs.close();
			prepareStatement.close();
			connection.close();
			return clas;
		} else {
			rs.close();
			prepareStatement.close();
			connection.close();
			return null;
		}
	}

	public static Class getClassByName(String name) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "SELECT class_id, class_name, amount FROM Class WHERE class_name LIKE ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, "%" + name + "%");
		ResultSet rs = prepareStatement.executeQuery();
		if (rs.next()) {
			Class clas = new Class(rs.getInt("class_id"), rs.getString("class_name"), rs.getInt("amount"));
			rs.close();
			prepareStatement.close();
			connection.close();
			return clas;
		} else {
			rs.close();
			prepareStatement.close();
			connection.close();
			return null;
		}
	}

	public static void SearchTheClass(String name) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "SELECT class_id, class_name, amount FROM Class WHERE class_name LIKE ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, "%" + name + "%");
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			System.out.printf("%-15d", rs.getInt("class_id"));
			System.out.printf("%-25s", rs.getString("class_name"));
			System.out.printf("%-20d", rs.getInt("amount"));
			System.out.println();
		}
		connection.close();
		prepareStatement.close();
		connection.close();
	}

	public static void DeleteClassByID(int classID) throws SQLException {
		Connection connection = utils.ConnectDB.getMyConnection();
		String sql = "DELETE FROM Class WHERE class_id = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, classID);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
	}

	public static ArrayList<Class> getAllClass() throws SQLException {
		ArrayList<Class> listClass = new ArrayList<>();
		String sql = "SELECT class_id, class_name, amount FROM Class";
		Connection connection = utils.ConnectDB.getMyConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery(sql);
		while (rs.next()) {
			Class clas = new Class(rs.getInt("class_id"), rs.getString("class_name"), rs.getInt("amount"));
			listClass.add(clas);
		}
		rs.close();
		prepareStatement.close();
		connection.close();
		return listClass;
	}
}
