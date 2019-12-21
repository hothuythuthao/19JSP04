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
import Library.Model.UserBook;
import Library.Service.UserBookService;
import Library.Service.Impl.UserBookServiceImpl;

@WebServlet("/DangKyMuonSachServlet")
public class DangKyMuonSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DangKyMuonSachServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "Bạn chưa đăng nhập!");
			request.getRequestDispatcher("/DangXuat.jsp").forward(request, response);
		} else {
			try {
				UserBookService ubService = new UserBookServiceImpl();
				List<UserBook> listUserBook = ubService.danhSachDangKy();
				if(listUserBook.size() == 0)	{
					request.setAttribute("msg", "Danh sách đăng ký mượn sách trống!");
					request.getRequestDispatcher("notice.jsp").forward(request, response);
				}
				else	{
					request.setAttribute("listUserBook", listUserBook);
					request.getRequestDispatcher("DangKyMuonSach.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Error is : " + e);
			}
		}
	}

}
