package Library.Service;

import java.sql.SQLException;
import java.util.List;

import Library.Model.User;

public interface UserService {
	public List<User> getAll() throws ClassNotFoundException, SQLException;

	public User getUserByIdAndPassword(String userID, String password) throws ClassNotFoundException, SQLException;

	public User getUserById(String userID) throws SQLException, ClassNotFoundException;

	public void Delete(String userID) throws ClassNotFoundException, SQLException;

	public void Update(User user) throws ClassNotFoundException, SQLException;

	public boolean getUserByEmail(String email, String userID) throws ClassNotFoundException, SQLException;

	public String createNewID() throws ClassNotFoundException, SQLException;

	public void Insert(String userID, String userName, String email, String password)
			throws ClassNotFoundException, SQLException;
}
