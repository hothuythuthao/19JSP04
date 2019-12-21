<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MIXI GAMING - USER</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="src/css/index.css">
</head>
<body>
	<%
		String email = request.getParameter("email");
    	String password = request.getParameter("password");
	%>
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
						<p>Hotline: +999999999</p>
					</div>
				</div>
			</div>
		</div>
		<div class="form-container-login">
			<h1>Hello <%=email%></h1>
		</div>
	</div>
</body>
</html>