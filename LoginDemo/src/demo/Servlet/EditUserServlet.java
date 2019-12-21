package demo.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.DAO.UserDAO;
import demo.DAO.Impl.UserDAOImpl;
import demo.Model.User;

@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		try {
			Connection conn = demo.Connect.ConnectionUtils.getMyConnection();
			UserDAO userDAO = new UserDAOImpl();
			User user = userDAO.getUserById(id);
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/LoginDemo/EditUserView.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("--Error is : " + e);
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			Connection conn = demo.Connect.ConnectionUtils.getMyConnection();
			UserDAO userDAO = new UserDAOImpl();
			User user = new User(id, userName, password);
			
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/LoginDemo/EditUserView.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("--Error is : " + e);
		}		
	}

}
