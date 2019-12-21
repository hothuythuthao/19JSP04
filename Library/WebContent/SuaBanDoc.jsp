<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Library.Model.*"%>
<%@page import="java.util.*"%>
<%@include file="/includes/headerUser.jsp"%>
<%@ include file="/includes/listDefault.jsp"%>
<%@ include file="/includes/listAdmin.jsp"%>

<section>
	<div class="form-container-register">
			<form method="POST" action="<%=request.getContextPath()%>/SuaBanDocServlet">
				<div>
					<h2>SỬA THÔNG TIN BẠN ĐỌC</h2>
				</div>
				<div>
					<table class="form-table-register">
						<tr>
							<td class="item-table-register"><label>Họ và tên : </label></td>
							<td><input type="text" name="userName" value="${user.userName}" required></td>
						</tr>
						<tr>
							<td><label>Mật khẩu : </label></td>
							<td><input type="text" name="password" value="${user.password}" required></td>
						</tr>
						<tr>
							<td><label>Email : </label></td>
							<td><input type="email" name="email" value="${user.email}" required></td>
						</tr>
						<tr>
							<td><label>Phân quyền : </label></td>
							<td>
								<input type="radio" name="isAdmin" value="1">
								<label>User</label>
							</td>
							<td>
								<input type="radio" name="isAdmin" value="2">
								<label>Admin</label>
							</td>
						</tr>
						<tr>
							<td><label>Trạng thái : </label></td>
							<td>
								<input type="radio" name="status" value="DA">
								<label>Default Account</label>
							</td>
							<td>
								<input type="radio" name="status" value="LA">
								<label>Lock Account</label>
							</td>
						</tr>
						<tr>
							<td><input type="hidden" name="userID" value="${user.userID}"></td>
						</tr>
					</table>
				</div>
				<div>
					<input class="edit" type="submit" name="submit" value="Xác nhận">
					<input class="reset" type="reset" name="reset" value="Nhập lại">
				</div>
			</form>
		</div>
</section>
<%@ include file="/includes/footerDefault.jsp"%>
