<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Library.Model.*"%>
<%@page import="java.util.*"%>
<%@include file="/includes/headerUser.jsp"%>
<%@ include file="/includes/listDefault.jsp"%>
<%@ include file="/includes/listAdmin.jsp"%>

<section>
	<div class="form-container-display-ub">
		<form>
			<div>
				<h3>NHẬT KÝ MƯỢN TRẢ</h3>
			</div>
			<div>
				<table class="database-table-book">
					<tr>
						<th class="database-trth-ub">Mã phiếu mượn</th>
						<th class="database-trth-ub">Mã bạn đọc</th>
						<th class="database-trth-ub">Mã sách</th>
						<th class="database-trth-ub">Ngày mượn</th>
						<th class="database-trth-ub">Ngày phải trả</th>
						<th class="database-trth-ub">Ngày trả thực</th>
						<th class="database-trth-ub">Ngày đăng ký</th>
						<th class="database-trth-ub">Mã thủ thư</th>
					</tr>
					<c:forEach var="userBook" items="${listUserBook}">
						<tr>
							<td class="database-td-book">${userBook.ID}</td>
							<td class="database-td-book">${userBook.userID}</td>
							<td class="database-td-book">${userBook.bookID}</td>
							<td class="database-td-book">${userBook.borrowDate}</td>
							<td class="database-td-book">${userBook.returnDateExpected}</td>
							<td class="database-td-book">${userBook.returnDateReal}</td>
							<td class="database-td-book">${userBook.registerDate}</td>
							<td class="database-td-book">${userBook.empID}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>
</section>
<%@ include file="/includes/footerDefault.jsp"%>
