package demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserInfoServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("session_user");
		
		if (user == null) {
			response.sendRedirect(this.getServletContext().getContextPath() + "/login");
			return;
		}
		
		out.println("<html>");
        out.println("<head><title>Session User</title></head>");
        out.println("<body>");
        out.println("<h3>User Information: </h3>");
        out.println("<p>User Name: " + user.getName() + "</p>");
        out.println("<p>Email: " + user.getEmail() + "</p>");
        out.println("</body>");
        out.println("<html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
