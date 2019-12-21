package Library.Service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Library.Model.Book;
import Library.Service.BookService;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> getBookByChoose(String choose, String value) throws ClassNotFoundException, SQLException {
		Connection conn = Library.Connect.ConnectionUtils.getMyConnection();
		List<Book> listBook = new ArrayList<Book>();
		String sql = "SELECT book_id, book_name, book_author, publish_year, book_kind FROM book WHERE " + choose
				+ " LIKE ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, "%" + value + "%");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Book book = new Book(resultSet.getString("book_id"), resultSet.getString("book_name"),
					resultSet.getString("book_author"), resultSet.getString("publish_year"),
					resultSet.getString("book_kind"));
			listBook.add(book);
		}
		if (listBook.size() > 0) {
			return listBook;
		} else {
			return null;
		}
	}

	@Override
	public Book getBookByID(String bookID) throws ClassNotFoundException, SQLException {
		Connection conn = Library.Connect.ConnectionUtils.getMyConnection();
		String sql = "SELECT book_id, book_name, book_author, publish_year, book_kind FROM book WHERE book_id LIKE ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, bookID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Book book = new Book(resultSet.getString("book_id"), resultSet.getString("book_name"),
					resultSet.getString("book_author"), resultSet.getString("publish_year"),
					resultSet.getString("book_kind"));
			return book;
		} else {
			return null;
		}
	}

	@Override
	public List<Book> getAll() throws ClassNotFoundException, SQLException {
		Connection connection = Library.Connect.ConnectionUtils.getMyConnection();
		String sql = "SELECT book_id, book_name, book_author, publish_year, book_kind FROM book";
		List<Book> listBook = new ArrayList<>();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Book book = new Book(resultSet.getString("book_id"), resultSet.getString("book_name"),
					resultSet.getString("book_author"), resultSet.getString("publish_year"),
					resultSet.getString("book_kind"));
			listBook.add(book);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return listBook;
	}

}
