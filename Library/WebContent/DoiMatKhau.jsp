<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Library.Model.*"%>
<%@page import="java.util.*"%>
<c:choose>
	<c:when test="${sessionScope.user.isAdmin == 2}">

		<%@include file="/includes/headerUser.jsp"%>
		<%@ include file="/includes/listDefault.jsp"%>
		<%@ include file="/includes/listAdmin.jsp"%>
	</c:when>
	<c:otherwise>
		<%@include file="/includes/headerUser.jsp"%>
		<%@ include file="/includes/listDefault.jsp"%>
		<%@ include file="/includes/listUser.jsp"%>
	</c:otherwise>
</c:choose>
<section>
	<div class="form-container-password">
		<form method="POST"
			action="<%=request.getContextPath()%>/DoiMatKhauServlet"
			onsubmit="return checkChangePassword()">
			<div>
				<h2>ĐỔI MẬT KHẨU</h2>
			</div>
			<div>
				<table class="form-table-password">
					<tr>
						<td class="item-table-login"><label>Mật khẩu cũ: </label></td>
						<td><input type="password" name="oldPassword" required></td>
					</tr>
					<tr>
						<td><label>Mật khẩu mới: </label></td>
						<td><input type="password" name="newPassword" required></td>
					</tr>
					<tr>
						<td><label>Nhập lại mật khẩu: </label></td>
						<td><input type="password" name="reNewPassword" required></td>
					</tr>
				</table>
			</div>
			<div class="login-bot">
				<button class="changePassword" type="submit" id="submit">Xác nhận</button>
				<button class="reset" type="reset" name="reset">Nhập lại</button>
			</div>
		</form>
	</div>
</section>
<%@ include file="/includes/footerDefault.jsp"%>