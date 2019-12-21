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

@WebServlet("/XoaBanDocServlet")
public class XoaBanDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XoaBanDocServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User tmp = (User) request.getSession().getAttribute("user");
		if (tmp == null) {
			request.setAttribute("msg", "Bạn chưa đăng nhập!");
			request.getRequestDispatcher("/DangXuat.jsp").forward(request, response);
		} else	{
			try {
				String userID = request.getParameter("userID");
				UserService userService = new UserServiceImpl();
				userService.Delete(userID);
				List<User> listUser = userService.getAll();
				request.setAttribute("listUser", listUser);
				request.getRequestDispatcher("/QuanLyBanDoc.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Error is : " + e);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
