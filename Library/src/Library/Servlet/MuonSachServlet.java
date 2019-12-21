package Library.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Library.Model.User;
import Library.Service.UserBookService;
import Library.Service.Impl.UserBookServiceImpl;

@WebServlet("/MuonSachServlet")
public class MuonSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MuonSachServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "Bạn chưa đăng nhập!");
			request.getRequestDispatcher("/DangXuat.jsp").forward(request, response);
		} else {
			try {
				String bookID = request.getParameter("bookID");
				String userID = user.getUserID();
				LocalDate registerDate = LocalDate.now();
				UserBookService ubService = new UserBookServiceImpl();
				boolean rs = ubService.getUserBookByUIAndBI(userID, bookID);
				if (rs) {
					request.setAttribute("msg", "Bạn đã mượn sách này rồi.");
					request.getRequestDispatcher("notice.jsp").forward(request, response);
				} else {
					ubService.dangKyMuonSach(userID, bookID, registerDate);
					request.setAttribute("msg", "Đăng ký mượn sách thành công");
					request.getRequestDispatcher("notice.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Error is : " + e);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
