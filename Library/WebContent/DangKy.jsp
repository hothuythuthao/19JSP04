<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="Library.Model.User"%>
<%@ include file="/includes/headerDefault.jsp"%>
<%@ include file="/includes/listIndex.jsp"%>
<%
	User user = (User) session.getAttribute("user");
%>
<section>
	<div class="form-container-register">
		<form method="post"
			action="<%=request.getContextPath()%>/DangKyServlet"
			onsubmit="return checkRegister()">
			<div>
				<h2>ĐĂNG KÝ</h2>
			</div>
			<div>
				<table class="form-table-register">
					<tr>
						<td class="item-table-register"><label>Họ và tên: </label></td>
						<td><input type="text" name="userName" required></td>
					</tr>
					<tr>
						<td><label>Mật khẩu: </label></td>
						<td><input type="password" name="password" required></td>
					</tr>
					<tr>
						<td><label>Nhập lại mật khẩu: </label></td>
						<td><input type="password" name="confirmPassword" required></td>
					</tr>
					<tr>
						<td><label>Email : </label></td>
						<td><input type="email" name="email" required
							pattern="([a-zA-Z0-9]*)@([a-zA-Z]*).com"></td>
					</tr>
				</table>
			</div>
			<div>
				<input class="signup" type="submit" name="submit" value="Đăng ký">
				<input class="reset" type="reset" name="reset" value="Nhập lại">
			</div>
		</form>
	</div>
</section>
<%@ include file="/includes/footerDefault.jsp"%>
