package demo.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.Model.User;
import demo.Service.UserService;
import demo.Service.Impl.UserServiceImpl;

@WebServlet({"/", "/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoginDemo/LoginView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			Connection conn = demo.Connect.ConnectionUtils.getMyConnection();
			UserService userService = new UserServiceImpl();
			List<User> listUser = userService.getAll();
			for(User user : listUser)	{
				if(user.getUserName().equals(userName) && user.getPassword().equals(password))	{
					request.setAttribute("users", listUser);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoginDemo/ListUserView.jsp");
					dispatcher.forward(request, response);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("--Error is : " + e);
		}
		
	}

}
