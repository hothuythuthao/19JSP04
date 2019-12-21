package demo.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.DAO.UserDAO;
import demo.Model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> getAll() throws SQLException, ClassNotFoundException {
		List<User> listUser = new ArrayList<>();
		try {
			String sql = "SELECT user_id, user_name, user_password FROM user";
			Connection connection = demo.Connect.ConnectionUtils.getMyConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery(sql);
			while (rs.next()) {
				User user = new User(	rs.getInt("user_id"),
										rs.getString("user_name"),
										rs.getString("user_password"));
				listUser.add(user);
			}
			rs.close();
			prepareStatement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("--Error is: " + e);
		}
		return listUser;
	}

	@Override
	public User getUserByNameAndPass(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int Id) throws ClassNotFoundException, SQLException {
		Connection connection = demo.Connect.ConnectionUtils.getMyConnection();
		String sql = "SELECT user_id, user_name, user_password FROM user WHERE user_id=?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, Id);
		ResultSet rs = prepareStatement.executeQuery();
		if (rs.next()) {
			User user = new User(	rs.getInt("user_id"),
									rs.getString("student_name"),
									rs.getString("user_password"));
			rs.close();
			prepareStatement.close();
			connection.close();
			return user;
		} else {
			rs.close();
			prepareStatement.close();
			connection.close();
			return null;
		}
	}

	@Override
	public void Delete(int Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Insert(User user) throws SQLException, ClassNotFoundException {
		Connection connection = demo.Connect.ConnectionUtils.getMyConnection();
		String sql = "INSERT INTO User(user_name, user_password) VALUES(?, ?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, user.getUserName());
		prepareStatement.setString(2, user.getPassword());
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
		
	}

	@Override
	public void Update(User user) throws ClassNotFoundException, SQLException {
		Connection connection = demo.Connect.ConnectionUtils.getMyConnection();
		String sql = "UPDATE user SET user_name = ?, user_password = ? WHERE user_id = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, user.getUserName());
		prepareStatement.setString(2, user.getPassword());
		prepareStatement.setInt(3, user.getId());
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
		
	}

}
