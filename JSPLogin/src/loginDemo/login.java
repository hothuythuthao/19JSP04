package loginDemo;

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
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final User user = new User("Tee", "111111", "tee@gmail.com", "73 WSE", "Boy");
    
    public login() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contextPath = request.getContextPath();
		if(email.equals(user.getEmail()) && password.equals(user.getPassword()))	{
			out.println("<html>");
	        out.println("<head><title>Session User</title></head>");
	        out.println("<body>");
	        out.println("<center><div>");
	        out.println("<h3>User Information: </h3>");
	        out.println("<p>Email: " + email + "</p>");
	        out.println("<p>Password: " + password + "</p>");
	        out.println("<p>Name: " + user.getName() + "</p>");
	        out.println("<p>Gender: " + user.getGender() + "</p>");
	        out.println("<p>Address: " + user.getAddress() + "</p>");
	        out.println("</div></center>");
	        out.println("</body>");
	        out.println("<html>");
		}
		else	{
            response.sendRedirect(contextPath + "/loginDemo/registerHTML.jsp");
            return;
		}
	}

}
