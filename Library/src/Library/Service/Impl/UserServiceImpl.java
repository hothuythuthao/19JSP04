package Library.Service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Library.Model.User;
import Library.Service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public List<User> getAll() throws ClassNotFoundException, SQLException {
		List<User> listUser = new ArrayList<>();
		String sql = "SELECT user_id, user_name, email, password, isAdmin, status FROM user WHERE isAdmin != 2";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet resultSet = prepareStatement.executeQuery(sql);
		while (resultSet.next()) {
			User user = new User(resultSet.getString("user_id"), resultSet.getString("user_name"),
					resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("isAdmin"),
					resultSet.getString("status"));
			listUser.add(user);
		}
		resultSet.close();
		prepareStatement.close();
		connection.close();
		return listUser;
	}

	@Override
	public User getUserByIdAndPassword(String userID, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT user_id, user_name, email, password, isAdmin, status FROM user WHERE user_id LIKE ? AND password LIKE ?";
		Connection conn = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, userID);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			User user = new User(resultSet.getString("user_id"), resultSet.getString("user_name"),
					resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("isAdmin"),
					resultSet.getString("status"));
			resultSet.close();
			preparedStatement.close();
			conn.close();
			return user;
		} else {
			resultSet.close();
			preparedStatement.close();
			conn.close();
			return null;
		}
	}

	@Override
	public User getUserById(String userID) throws SQLException, ClassNotFoundException {
		String sql = "SELECT user_id, user_name, email, password, isAdmin, status FROM user WHERE user_id LIKE ?";
		Connection conn = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, userID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			User user = new User(resultSet.getString("user_id"), resultSet.getString("user_name"),
					resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("isAdmin"),
					resultSet.getString("status"));
			resultSet.close();
			preparedStatement.close();
			conn.close();
			return user;
		} else {
			resultSet.close();
			preparedStatement.close();
			conn.close();
			return null;
		}
	}

	@Override
	public void Delete(String userID) throws ClassNotFoundException, SQLException {
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		String sql = "DELETE FROM user WHERE user_id = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, userID);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
	}

	@Override
	public void Update(User user) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE user SET user_name = ?, email = ?, password = ?, isAdmin = ?, status = ? WHERE user_id LIKE ?";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getUserName());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setInt(4, user.getIsAdmin());
		preparedStatement.setString(5, user.getStatus());
		preparedStatement.setString(6, user.getUserID());
		preparedStatement.executeUpdate();
		preparedStatement.close();

	}

	@Override
	public boolean getUserByEmail(String email, String userID) throws ClassNotFoundException, SQLException {
		String sql = "SELECT user_id, user_name, email, password, isAdmin, status FROM user WHERE email LIKE ? AND user_id NOT LIKE ?";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, userID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			preparedStatement.close();
			connection.close();
			return true;
		} else {
			resultSet.close();
			preparedStatement.close();
			connection.close();
			return false;
		}
	}

	@Override
	public String createNewID() throws ClassNotFoundException, SQLException {
		String sql = "SELECT MAX(user_id) FROM user";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		if(resultSet.getString(1) == null)
            return "00001";
		String tmp = resultSet.getString(1);
		int id = Integer.parseInt(tmp.substring(1, 5)) + 1;
		tmp = "" + id;
		while (tmp.length() < 5)
			tmp = "0" + tmp;
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return tmp;
	}

	@Override
	public void Insert(String userID, String userName, String email, String password)
			throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO user(user_id, user_name, email, password) VALUES (?, ?, ?, ?)";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userID);
		preparedStatement.setString(2, userName);
		preparedStatement.setString(3, email);
		preparedStatement.setString(4, password);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

}
