package demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfoServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		String username = request.getParameter("text1");
        String password = request.getParameter("text2");
        
		out.println("<html>");
		out.println("<head><title>Hello Servlet</title></head>");
		out.println("<body>");
		out.println("<h1>Servlet with Annotation</h1>");
        out.println("<br><span>User Name: </span>");
        out.println(username);
        out.println("<br><span>Password: </span>");
        out.println(password);
		out.println("</body>");
		out.println("<html>");
		
        out.println("<style> span {color:red;} </style>");
 
        String requestURL = request.getRequestURL().toString();
        out.println("<br><span>requestURL: </span>");
        out.println(requestURL);
 
        String requestURI = request.getRequestURI();
        out.println("<br><span>requestURI: </span>");
        out.println(requestURI);
 
        String contextPath = request.getContextPath();
        out.println("<br><span>contextPath: </span>");
        out.println(contextPath);
 
        out.println("<br><span>servletPath: </span>");
        String servletPath = request.getServletPath();
        out.println(servletPath);
 
        String queryString = request.getQueryString();
        out.println("<br><span>queryString: </span>");
        out.println(queryString);
 
        String param1 = request.getParameter("text1");
        out.println("<br><span>User Name: </span>");
        out.println(param1);
 
        String param2 = request.getParameter("text2");
        out.println("<br><span>Password: </span>");
        out.println(param2);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
