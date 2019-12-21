package demo.Service.Impl;

import java.sql.SQLException;
import java.util.List;

import demo.DAO.UserDAO;
import demo.DAO.Impl.UserDAOImpl;
import demo.Model.User;
import demo.Service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public List<User> getAll() throws SQLException, ClassNotFoundException {
		UserDAO userDAO = new UserDAOImpl();
		List<User> listUser = userDAO.getAll();
		return listUser;
	}

	@Override
	public User getUserByNameAndPass(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(int Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Insert(User user) {
		
	}

	@Override
	public void Update(User user) {
		// TODO Auto-generated method stub
		
	}

}
