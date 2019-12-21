package Library.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Library.Model.UserBook;

public interface UserBookService {
	public void dangKyMuonSach(String userID, String bookID, LocalDate registerDate)
			throws SQLException, ClassNotFoundException;

	public List<UserBook> danhSachDangKy() throws ClassNotFoundException, SQLException;

	public UserBook getUserBookByID(int ID) throws SQLException, ClassNotFoundException;

	public void duyetMuonSach(UserBook userBook, String userID) throws SQLException, ClassNotFoundException;

	public List<UserBook> getAllUserBook() throws ClassNotFoundException, SQLException;

	public void huyDangKyMuon(int ID) throws ClassNotFoundException, SQLException;

	public boolean getUserBookByUIAndBI(String userID, String bookID) throws ClassNotFoundException, SQLException;

	public List<UserBook> getUserBookByUserID(String userID) throws ClassNotFoundException, SQLException;

	public List<UserBook> getUserBookByIDAndUI(int ID, String userID) throws ClassNotFoundException, SQLException;

	public boolean kiemTraTraSach(int ID) throws ClassNotFoundException, SQLException;

	public void dangKyTraSach(UserBook userBook) throws ClassNotFoundException, SQLException;

	public List<UserBook> danhSachTraSach() throws ClassNotFoundException, SQLException;

	public void duyetTraSach(int ID) throws ClassNotFoundException, SQLException;
}
