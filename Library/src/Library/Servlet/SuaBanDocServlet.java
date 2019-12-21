package Library.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Library.Model.User;
import Library.Service.UserService;
import Library.Service.Impl.UserServiceImpl;

@WebServlet("/SuaBanDocServlet")
public class SuaBanDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SuaBanDocServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User tmp = (User) request.getSession().getAttribute("user");
		if (tmp == null) {
			request.setAttribute("msg", "Bạn chưa đăng nhập!");
			request.getRequestDispatcher("/DangXuat.jsp").forward(request, response);
		} else {
			try {
				String userID = request.getParameter("userID");
				UserService userService = new UserServiceImpl();
				User user = userService.getUserById(userID);
				request.setAttribute("user", user);
				request.getRequestDispatcher("/SuaBanDoc.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Error is : " + e);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));
		String status = request.getParameter("status");
		User tmp = (User) request.getSession().getAttribute("user");
		if (tmp == null) {
			request.setAttribute("msg", "Bạn chưa đăng nhập!");
			request.getRequestDispatcher("/DangXuat.jsp").forward(request, response);
		} else {
			try {
				UserService userService = new UserServiceImpl();
				boolean rs = userService.getUserByEmail(email, userID);
				if (rs) {
					request.setAttribute("msg", "Chỉnh sửa thất bại. Email đã tồn tại!");
					request.getRequestDispatcher("notice.jsp").forward(request, response);
				} else {
					User user = new User(userID, userName, email, password, isAdmin, status);
					userService.Update(user);
					List<User> listUser = userService.getAll();
					request.setAttribute("listUser", listUser);
					request.getRequestDispatcher("/QuanLyBanDoc.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("--Error is : " + e);
			}
		}

	}

}
