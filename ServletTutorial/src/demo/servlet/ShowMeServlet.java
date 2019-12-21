package demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/showMe"}, initParams = {
		@WebInitParam(name = "userName", value = "admin") })
public class ShowMeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowMeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = this.getServletConfig().getInitParameter("userName");
		String value = (String) request.getAttribute("Goodbye " + username );
		 
        ServletOutputStream out = response.getOutputStream();
 
        out.println("<h1>ShowMeServlet</h1>");
        out.println(value);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
