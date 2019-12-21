package Library.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Library.Model.Employee;
import Library.Model.User;
import Library.Service.UserService;
import Library.Service.Impl.UserServiceImpl;

@WebServlet("/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DangNhapServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		System.out.println(userID);
		System.out.println(password);
		try {
			String msg = "";
			UserService userService = new UserServiceImpl();
			User user = userService.getUserByIdAndPassword(userID, password);
			if (user == null) {
				msg = "Sai mã đăng nhập hoặc mật khẩu!";
				request.setAttribute("msg", msg);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DangXuat.jsp");
				requestDispatcher.forward(request, response);
			} else {
				if (user.getStatus().equals("DA")) {
					if (user.getIsAdmin() == 1) {
						request.getSession().setAttribute("user", user);
						msg = "Xin chào bạn đọc : " + user.getUserName();
					} else {
						Employee emp = new Employee(user);
						request.getSession().setAttribute("user", emp);
						msg = "Xin chào thủ thư : " + user.getUserName();
					}
				} else {
					msg = "Tài khoản của bạn đã bị khóa!";
				}
				request.setAttribute("msg", msg);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("notice.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error is : " + e);
		}
	}

}
