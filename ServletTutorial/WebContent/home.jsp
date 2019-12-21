<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WHY SO EASY</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div>
		<h3 style="color: blue">JSP Action jsp: useBean</h3>
		<jsp:useBean id="User" class="demo.servlet.User"></jsp:useBean>
		<jsp:setProperty name="User" property="name" value="Tee"/>
		<jsp:setProperty name="User" property="email" value="tee@gmail.com"/>
		<p style="color: violet">
			<jsp:getProperty property="name" name="User"/>
		</p>
		<p style="color: violet">
			<jsp:getProperty property="email" name="User"/>
		</p>
	</div>
	<div>
		<%!int sum(int a, int b) {
		return a + b;
		}%>
		<h3>
			<%
				out.print("This is content hihi");
			%>
		</h3>
		<h5><%=request.getServerName()%></h5>
		<h5><%=response.getLocale().toString()%></h5>

		<%
			boolean isAdmin = false;
			if (isAdmin) {
		%>
		<p>
			Mo ta 1 :
			<%=isAdmin%></p>
		<%
			} else {
		%>
		<p>
			Mo ta 2 :
			<%=isAdmin%></p>
		<%
			}
			int a = 3, b = 7;
			out.println("Sum a + b : " + sum(a, b));
		%>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>