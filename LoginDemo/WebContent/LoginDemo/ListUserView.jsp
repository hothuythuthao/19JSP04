<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>MIXI GAMING - LOGIN</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="src/css/index.css">
</head>
<body>
	<div class="container">
		<div class="content-head">
			<div class="content-head-top">
				<a href="#" target="blank" class="signin-head">
                	<span class="glyphicon glyphicon-user"></span> LOGIN
            	</a>
				<a href="#" target="blank" class="signup-head">
                	<span class="glyphicon glyphicon-edit"></span> REGISTER
            	</a>
			</div>
			<div class="content-head-bot">
				<div class="logo-head-bot">
					<a href="#" target="blank"><img src="src/image/logomixi.png" class="image-logo-head"></a>
					<div class="slogan">
						<p><span class="compulsory">MIXI</span>GAMING FROM <span class="compulsory">DANANG</span> WITH <span class="compulsory">LOVE</span></p>
					</div>
				</div>
				<div class="info-head-bot">
					<div class="info-top">
						<img src="src/image/vn.png" class="image-info-head">
						<img src="src/image/anh.png" class="image-info-head">
						<a href="#" target="blank">
							<span class="glyphicon glyphicon-search glyphicon-plus"></span>
						</a>
					</div>
					<div class="info-bot">
						<p>Hotline: +123456789</p>
					</div>
				</div>
			</div>
		</div>
		<div>
			<form method="get"  action="<%=request.getContextPath()%>/AddUserServlet">
				<input class="add" type="submit" name="add" value="Add User">
			</form>
		</div>
		<div>
		<form method="get" action="<%=request.getContextPath()%>/EditUserServlet">
			<table class="database-table">
				<tr>
					<th class="database-trth">USER ID</th>
					<th  class="database-trth">USER NAME</th>
					<th  class="database-trth">USER PASSWORD</th>
					<th colspan="2">ACTION</th>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td class="database-td">${user.id}</td>
						<td class="database-td">${user.userName}</td>
						<td class="database-td">${user.password}</td>
						<td><input class="edit" type="submit" name="edit" value="Edit"></td>
						<td><input class="del" type="submit" name="del" value="Delete"></td>
					</tr>
				</c:forEach>
			</table>
		</form>
		</div>
	</div>
</body>
</html>