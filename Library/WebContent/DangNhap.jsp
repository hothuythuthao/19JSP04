<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="Library.Model.User"%>
<%@ include file="/includes/headerDefault.jsp"%>
<%@ include file="/includes/listIndex.jsp"%>
<%
	User user = (User) session.getAttribute("user");
%>
<section>
	<div class="form-container-login">
		<form method="post"
			action="<%=request.getContextPath()%>/DangNhapServlet">
			<div>
				<h2>ĐĂNG NHẬP</h2>
			</div>
			<div>
				<table class="form-table-login">
					<tr>
						<td class="item-table-login"><label>Mã đăng nhập : </label></td>
						<td><input type="text" name="userID"></td>
					</tr>
					<tr>
						<td><label>Mật khẩu : </label></td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
			</div>
			<div class="login-bot">
				<input class="login" type="submit" name="submit" value="Đăng nhập">
				<input class="reset" type="reset" name="reset" value="Nhập lại">
			</div>
		</form>
	</div>
</section>
<%@ include file="/includes/footerDefault.jsp"%>
