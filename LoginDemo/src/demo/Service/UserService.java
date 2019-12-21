package demo.Service;

import java.sql.SQLException;
import java.util.List;

import demo.Model.User;

public interface UserService {
	public List<User> getAll() throws SQLException, ClassNotFoundException;
	public User getUserByNameAndPass (String userName, String password);
	public User getUserById (int Id);
	public void Delete(int Id);
	public void Insert(User user);
	public void Update(User user);
}
