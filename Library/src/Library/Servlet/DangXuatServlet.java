package Library.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Library.Model.User;

@WebServlet("/DangXuatServlet")
public class DangXuatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DangXuatServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String userName = user.getUserName();
		request.getSession().invalidate();
		request.setAttribute("msg", "Tạm biệt : " + userName);
		request.getRequestDispatcher("DangXuat.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
