package Library.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Library.Model.User;
import Library.Service.UserService;
import Library.Service.Impl.UserServiceImpl;

@WebServlet("/DoiMatKhauServlet")
public class DoiMatKhauServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoiMatKhauServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "Bạn chưa đăng nhập!");
			request.getRequestDispatcher("/DangXuat.jsp").forward(request, response);
		} else {
			try {
				String oldPassword = request.getParameter("oldPassword");
				String newPassword = request.getParameter("newPassword");
				if (user.getPassword().equals(oldPassword)) {
					user.setPassword(newPassword);
					UserService userService = new UserServiceImpl();
					userService.Update(user);
					request.setAttribute("msg", "Đổi mật khẩu thành công!");
					request.getRequestDispatcher("/notice.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "Đổi mật khẩu thất bại!");
					request.getRequestDispatcher("/notice.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Error is : " + e);
			}
		}

	}

}
