package Library.Service;

import java.sql.SQLException;
import java.util.List;

import Library.Model.Book;

public interface BookService {
	public List<Book> getBookByChoose(String choose, String value) throws ClassNotFoundException, SQLException;

	public Book getBookByID(String bookID) throws ClassNotFoundException, SQLException;

	public List<Book> getAll() throws ClassNotFoundException, SQLException;
}
