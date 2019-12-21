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
	<div class="form-container-display-book">
		<form method="GET">
			<div>
				<h3>THÔNG TIN SÁCH</h3>
			</div>
			<div>
				<table class="database-table-book">
					<tr>
						<th class="database-trth-book">Mã sách</th>
						<th class="database-trth-book">Tên sách</th>
						<th class="database-trth-book">Tác giả</th>
						<th class="database-trth-book">Năm xuất bản</th>
						<th class="database-trth-book">Thể loại</th>
						<th class="database-trth-book"></th>
					</tr>
					<c:forEach var="book" items="${listBook}">
						<tr>
							<td class="database-td-book"><c:out value="${book.bookID}" /></td>
							<td class="database-td-book"><c:out value="${book.bookName}" /></td>
							<td class="database-td-book"><c:out
									value="${book.bookAuthor}" /></td>
							<td class="database-td-book"><c:out
									value="${book.publishYear}" /></td>
							<td class="database-td-book"><c:out value="${book.bookKind}" /></td>
							<td class="database-td-book">
								<button class="borrow">
									<a
										href="MuonSachServlet?bookID=<c:out value="${book.bookID}"/>">Mượn
										sách</a>
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