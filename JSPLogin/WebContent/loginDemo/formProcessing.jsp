<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Processing</title>
</head>
<body>
	<h3>Parameter values:</h3>
  	<%
    	String name = request.getParameter("name");
    	String password = request.getParameter("password");
    	String email = request.getParameter("email");
    	String address = request.getParameter("address");
    	String gender = request.getParameter("gender"); 
  	%>
  
  Name: <%=name %> <br>
  Password: <%=password %> <br>
  Email: <%=email %> <br>
  Address: <%=address %> <br>
  
  Gender: <%=gender %> <br>
  
</body>
</html>