package demo.DAO;

import java.sql.SQLException;
import java.util.List;

import demo.Model.User;

public interface UserDAO {
	public List<User> getAll() throws SQLException, ClassNotFoundException;
	public User getUserByNameAndPass (String userName, String password);
	public User getUserById (int Id) throws ClassNotFoundException, SQLException;
	public void Delete(int Id);
	public void Insert(User user) throws SQLException, ClassNotFoundException;
	public void Update(User user) throws ClassNotFoundException, SQLException;
}
