package demo.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.DAO.UserDAO;
import demo.DAO.Impl.UserDAOImpl;
import demo.Model.User;
import demo.Service.UserService;
import demo.Service.Impl.UserServiceImpl;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/LoginDemo/AddUserView.jsp");
        return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			Connection conn = demo.Connect.ConnectionUtils.getMyConnection();
			UserDAO userDAO = new UserDAOImpl();
			User user = new User(userName, password);
			userDAO.Insert(user);
			UserService userService = new UserServiceImpl();
			List<User> listUser = userService.getAll();
			request.setAttribute("users", listUser);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoginDemo/ListUserView.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("--Error is : " + e);
		}
	}

}
