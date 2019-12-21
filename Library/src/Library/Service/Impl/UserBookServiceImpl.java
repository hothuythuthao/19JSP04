package Library.Service.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Library.Model.UserBook;
import Library.Service.UserBookService;

public class UserBookServiceImpl implements UserBookService {
	@Override
	public void dangKyMuonSach(String userID, String bookID, LocalDate registerDate)
			throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO user_book(user_id, book_id, register_date) VALUES (?, ?, ?)";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, userID);
		prepareStatement.setString(2, bookID);
		prepareStatement.setDate(3, Date.valueOf(LocalDate.now()));
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
	}

	@Override
	public List<UserBook> danhSachDangKy() throws ClassNotFoundException, SQLException {
		List<UserBook> listUserBook = new ArrayList<>();
		String sql = "SELECT id, user_id, book_id, register_date FROM user_book WHERE emp_id IS NULL";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet resultSet = prepareStatement.executeQuery(sql);
		while (resultSet.next()) {
			UserBook userBook = new UserBook(resultSet.getInt("id"), resultSet.getString("user_id"),
					resultSet.getString("book_id"), resultSet.getDate("register_date"));
			listUserBook.add(userBook);
		}
		resultSet.close();
		prepareStatement.close();
		connection.close();
		return listUserBook;
	}

	@Override
	public UserBook getUserBookByID(int ID) throws SQLException, ClassNotFoundException {
		String sql = "SELECT id, user_id, book_id, borrow_date, return_date_expected, return_date_real, register_date, emp_id, status FROM user_book WHERE id = ?";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, ID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			UserBook userBook = new UserBook(resultSet.getInt("id"), resultSet.getString("user_id"),
					resultSet.getString("book_id"), resultSet.getDate("borrow_date"),
					resultSet.getDate("return_date_expected"), resultSet.getDate("return_date_real"),
					resultSet.getDate("register_date"), resultSet.getString("emp_id"), resultSet.getInt("status"));
			resultSet.close();
			preparedStatement.close();
			connection.close();
			return userBook;
		} else {
			resultSet.close();
			preparedStatement.close();
			connection.close();
			return null;
		}
	}

	@Override
	public void duyetMuonSach(UserBook userBook, String userID) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE user_book SET user_id = ?, book_id = ?, borrow_date = ?, return_date_expected = ?, register_date = ?, emp_id = ?, status = ? WHERE id = ?";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userBook.getUserID());
		preparedStatement.setString(2, userBook.getBookID());
		preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
		preparedStatement.setDate(4, Date.valueOf(LocalDate.now().plusMonths(1)));
		preparedStatement.setDate(5, userBook.getRegisterDate());
		preparedStatement.setString(6, userID);
		preparedStatement.setInt(7, userBook.getStatus());
		preparedStatement.setInt(8, userBook.getID());
		preparedStatement.executeUpdate();
		preparedStatement.close();

	}

	@Override
	public List<UserBook> getAllUserBook() throws ClassNotFoundException, SQLException {
		List<UserBook> listUserBook = new ArrayList<>();
		String sql = "SELECT id, user_id, book_id, borrow_date, return_date_expected, return_date_real, register_date, emp_id, status FROM user_book";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet resultSet = prepareStatement.executeQuery(sql);
		while (resultSet.next()) {
			UserBook userBook = new UserBook(resultSet.getInt("id"), resultSet.getString("user_id"),
					resultSet.getString("book_id"), resultSet.getDate("borrow_date"),
					resultSet.getDate("return_date_expected"), resultSet.getDate("return_date_real"),
					resultSet.getDate("register_date"), resultSet.getString("emp_id"), resultSet.getInt("status"));
			listUserBook.add(userBook);
		}
		resultSet.close();
		prepareStatement.close();
		connection.close();
		return listUserBook;
	}

	@Override
	public void huyDangKyMuon(int ID) throws ClassNotFoundException, SQLException {
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		String sql = "DELETE FROM user_book WHERE id = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, ID);
		prepareStatement.executeUpdate();
		prepareStatement.close();
		connection.close();
	}

	@Override
	public boolean getUserBookByUIAndBI(String userID, String bookID) throws ClassNotFoundException, SQLException {
		String sql = "SELECT id, user_id, book_id, borrow_date, return_date_expected, return_date_real, register_date, emp_id, status FROM user_book WHERE user_id LIKE ? AND book_id LIKE ?";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userID);
		preparedStatement.setString(2, bookID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			resultSet.close();
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
	public List<UserBook> getUserBookByUserID(String userID) throws ClassNotFoundException, SQLException {
		String sql = "SELECT id, user_id, book_id, borrow_date, return_date_expected, return_date_real, register_date, emp_id, status FROM user_book WHERE user_id LIKE ?  AND emp_id IS NOT NULL";
		List<UserBook> listUserBook = new ArrayList<>();
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userID);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			UserBook userBook = new UserBook(resultSet.getInt("id"), resultSet.getString("user_id"),
					resultSet.getString("book_id"), resultSet.getDate("borrow_date"),
					resultSet.getDate("return_date_expected"), resultSet.getDate("return_date_real"),
					resultSet.getDate("register_date"), resultSet.getString("emp_id"), resultSet.getInt("status"));
			listUserBook.add(userBook);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return listUserBook;
	}

	@Override
	public List<UserBook> getUserBookByIDAndUI(int ID, String userID) throws ClassNotFoundException, SQLException {
		String sql = "SELECT id, user_id, book_id, borrow_date, return_date_expected, return_date_real, register_date, emp_id, status FROM user_book WHERE id = ? AND user_id LIKE ?";
		List<UserBook> listUserBook = new ArrayList<>();
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, ID);
		preparedStatement.setString(2, userID);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			UserBook userBook = new UserBook(resultSet.getInt("id"), resultSet.getString("user_id"),
					resultSet.getString("book_id"), resultSet.getDate("borrow_date"),
					resultSet.getDate("return_date_expected"), resultSet.getDate("return_date_real"),
					resultSet.getDate("register_date"), resultSet.getString("emp_id"), resultSet.getInt("status"));
			listUserBook.add(userBook);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return listUserBook;
	}

	@Override
	public boolean kiemTraTraSach(int ID) throws ClassNotFoundException, SQLException {
		String sql = "SELECT id, user_id, book_id, borrow_date, return_date_expected, return_date_real, register_date, emp_id, status FROM user_book WHERE id = ? AND return_date_real IS NULL";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, ID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			resultSet.close();
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
	public void dangKyTraSach(UserBook userBook) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE user_book SET user_id = ?, book_id = ?, borrow_date = ?, return_date_expected = ?, return_date_real = ?, register_date = ?, emp_id = ?, status = ? WHERE id = ?";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userBook.getUserID());
		preparedStatement.setString(2, userBook.getBookID());
		preparedStatement.setDate(3, userBook.getBorrowDate());
		preparedStatement.setDate(4, userBook.getReturnDateExpected());
		preparedStatement.setDate(5, userBook.getReturnDateReal());
		preparedStatement.setDate(6, userBook.getRegisterDate());
		preparedStatement.setString(7, userBook.getEmpID());
		preparedStatement.setInt(8, userBook.getStatus());
		preparedStatement.setInt(9, userBook.getID());
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	@Override
	public List<UserBook> danhSachTraSach() throws ClassNotFoundException, SQLException {
		List<UserBook> listUserBook = new ArrayList<>();
		String sql = "SELECT id, user_id, book_id, borrow_date, return_date_expected, return_date_real, register_date, emp_id, status FROM user_book WHERE status = 1";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet resultSet = prepareStatement.executeQuery(sql);
		while (resultSet.next()) {
			UserBook userBook = new UserBook(resultSet.getInt("id"), resultSet.getString("user_id"),
					resultSet.getString("book_id"), resultSet.getDate("borrow_date"),
					resultSet.getDate("return_date_expected"), resultSet.getDate("return_date_real"),
					resultSet.getDate("register_date"), resultSet.getString("emp_id"), resultSet.getInt("status"));
			listUserBook.add(userBook);
		}
		resultSet.close();
		prepareStatement.close();
		connection.close();
		return listUserBook;
	}

	@Override
	public void duyetTraSach(int ID) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE user_book SET return_date_real = ?, status = ? WHERE id = ?";
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDate(1, Date.valueOf(LocalDate.now()));
		preparedStatement.setInt(2, 0);
		preparedStatement.setInt(3, ID);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
	}
}
