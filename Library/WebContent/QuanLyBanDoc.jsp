<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Library.Model.*"%>
<%@page import="java.util.*"%>
<%@include file="/includes/headerUser.jsp"%>
<%@ include file="/includes/listDefault.jsp"%>
<%@ include file="/includes/listAdmin.jsp"%>

<section>
	<div class="form-container-display-user">
		<form method="GET">
			<div>
				<h3>DANH SÁCH BẠN ĐỌC</h3>
			</div>
			<div>
				<table class="database-table-user">
					<tr>
						<th class="database-trth-user">Mã bạn đọc</th>
						<th class="database-trth-user">Họ và tên</th>
						<th class="database-trth-user">Email</th>
						<th class="database-trth-user">Mật khẩu</th>
						<th class="database-trth-user">Trạng Thái</th>
						<th class="database-trth-user" colspan="2"></th>
					</tr>
					<c:forEach items="${listUser}" var="user">
						<tr>
							<td class="database-td-user">${user.userID}</td>
							<td class="database-td-user">${user.userName}</td>
							<td class="database-td-user">${user.email}</td>
							<td class="database-td-user">${user.password}</td>
							<td class="database-td-user">${user.status}</td>
							<td class="database-td-user">
								<button class="borrow">
									<a
										href="SuaBanDocServlet?userID=<c:out value="${user.userID}"/>">Sửa</a>
								</button>
							</td>
							<td class="database-td-user">
								<button class="borrow">
									<a
										href="XoaBanDocServlet?userID=<c:out value="${user.userID}"/>">Xóa</a>
								</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>
</section>
<%@ include file="/includes/footerDefault.jsp"%>
