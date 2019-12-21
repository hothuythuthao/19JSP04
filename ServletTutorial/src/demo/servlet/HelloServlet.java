package demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hello", "/helloServlet" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void InitParamServlet() {
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
        
        String forward = request.getParameter("forward");
		request.setAttribute("username", "Tee");
		request.setAttribute("password", "123456");
		
		if ("true".equals(forward)) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/goodbye");
			dispatcher.forward(request, response);
            return;
		}
		
		out.println("<html>");
		out.println("<head><title>Hello Servlet</title></head>");
		out.println("<body>");
		out.println("<h1>Hello " + request.getAttribute("username") + "</h1>");
		out.println("<p> Username : </p>" + request.getAttribute("username"));
		out.println("<p> Password : </p>" + request.getAttribute("password"));
		out.println("</body>");
		out.println("<html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
