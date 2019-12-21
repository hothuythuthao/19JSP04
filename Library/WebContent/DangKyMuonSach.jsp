<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Library.Model.*"%>
<%@page import="java.util.*"%>
<%@include file="/includes/headerUser.jsp"%>
<%@ include file="/includes/listDefault.jsp"%>
<%@ include file="/includes/listAdmin.jsp"%>

<section>
	<div class="form-container-display-book">
		<form>
			<div>
				<h3>DANH SÁCH ĐĂNG KÝ MƯỢN SÁCH</h3>
			</div>
			<div>
				<table class="database-table-book">
					<tr>
						<th class="database-trth-register-book">Mã bạn đọc</th>
						<th class="database-trth-register-book">Mã sách</th>
						<th class="database-trth-register-book">Ngày đăng ký</th>
						<th class="database-trth-register-book" colspan="2">Tác vụ</th>
					</tr>
					<c:forEach var="listUserBook" items="${listUserBook}">
						<input type="hidden" name="ID" value="${listUserBook.ID}">
						<tr>
							<td class="database-td-book">${listUserBook.userID}</td>
							<td class="database-td-book">${listUserBook.bookID}</td>
							<td class="database-td-book">${listUserBook.registerDate}</td>
							<td class="database-td-book">
								<button class="borrow">
									<a
										href="DuyetMuonSachServlet?ID=<c:out value="${listUserBook.ID}"/>">Duyệt</a>
								</button>
							</td>
							<td class="database-td-book">
								<button class="borrow">
									<a
										href="HuyMuonSachServlet?ID=<c:out value="${listUserBook.ID}"/>">Hủy</a>
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
