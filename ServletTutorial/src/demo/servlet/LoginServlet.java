package demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		
		HttpSession session = request.getSession();
		
		String forward = request.getParameter("forward");
		
		User user = new User("Tee", "whysoeasy@gmail.com");
		
		session.setAttribute("session_user", user);
		
		if ("true".equals(forward)) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/userInfo");
			dispatcher.forward(request, response);
            return;
		}
		
		out.println("<html>");
        out.println("<head><title>Session User</title></head>");
        out.println("<body>");
        out.println("<h1>Hello " + user.getName() + "</h1>");
        out.println("<a href='userInfo'>View User Info</a>");
        out.println("</body>");
        out.println("<html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
