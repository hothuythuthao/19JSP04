<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="Library.Model.User"%>
<%@page import="Library.Model.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MIXI LIBRARY</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="javascript/action.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
</head>
<body>
	<div class="container">
		<div class="content-head">
			<div class="content-head-top">
				<a href="ThongTinCaNhan.jsp" class="signin-head"> <span
					class="glyphicon glyphicon-user"></span> ${user.userName}
				</a> <a href="DangXuatServlet" class="signup-head"> <span
					class="glyphicon glyphicon-share"></span> Thoát
				</a>
			</div>
			<div class="content-head-bot">
				<div class="logo-head-bot">
					<a href="index.jsp"><img src="images/logomixi.png"
						class="image-logo-head"></a>
					<div class="slogan">
						<p>
							<span class="compulsory">MIXI</span>LIBRARY FROM <span
								class="compulsory">DANANG</span> WITH <span class="compulsory">LOVE</span>
						</p>
					</div>
				</div>
				<div class="info-head-bot">
					<div class="info-top">
						<img src="images/vn.png" class="image-info-head"> <img
							src="images/anh.png" class="image-info-head"> <a href="#"
							target="blank"> <span
							class="glyphicon glyphicon-search glyphicon-plus"></span>
						</a>
					</div>
					<div class="info-bot">
						<p>Hotline: +123456789</p>
					</div>
				</div>
			</div>
		</div>