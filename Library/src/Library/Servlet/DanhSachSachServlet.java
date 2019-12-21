package Library.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Library.Model.Book;
import Library.Model.User;
import Library.Service.BookService;
import Library.Service.Impl.BookServiceImpl;

@WebServlet("/DanhSachSachServlet")
public class DanhSachSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DanhSachSachServlet() {
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
				BookService bookService = new BookServiceImpl();
				List<Book> listBook = bookService.getAll();
				request.setAttribute("listBook", listBook);
				request.getRequestDispatcher("/DanhSachSach.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Error is : " + e);
			}
		}
	}

}
