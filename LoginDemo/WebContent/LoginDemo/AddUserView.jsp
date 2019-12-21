<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/AddUserServlet">
		<table class="form-table">
			<tr>
				<td class="item-table"><label>User Name<span class="compulsory">*</span> : </label></td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td><label>Password<span class="compulsory">*</span> : </label></td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input class="add-user" type="submit" name="add" value="Add">
		<input class="reset" type="reset" name="reset" value="Reset">
	</form>
</body>
</html>