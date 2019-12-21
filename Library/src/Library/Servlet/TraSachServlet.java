package Library.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Library.Model.User;
import Library.Model.UserBook;
import Library.Service.UserBookService;
import Library.Service.Impl.UserBookServiceImpl;

@WebServlet("/TraSachServlet")
public class TraSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TraSachServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "Bạn chưa đăng nhập!");
			request.getRequestDispatcher("/DangXuat.jsp").forward(request, response);
		} else {

			try {
				int ID = Integer.parseInt(request.getParameter("ID"));
				UserBookService ubService = new UserBookServiceImpl();
				if(ubService.kiemTraTraSach(ID))	{
					UserBook userBook = ubService.getUserBookByID(ID);
					userBook.setStatus(1);
					ubService.dangKyTraSach(userBook);
					request.setAttribute("msg", "Đăng ký trả sách thành công!");
					request.getRequestDispatcher("notice.jsp").forward(request, response);
				}
				else	{
					request.setAttribute("msg", "Bạn đã trả sách này rồi!");
					request.getRequestDispatcher("notice.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Error is : " + e);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}