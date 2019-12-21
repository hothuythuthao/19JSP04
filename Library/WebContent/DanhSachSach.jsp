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
	<div class="form-container-display-user">
		<form method="GET">
			<div>
				<h3>THƯ VIỆN SÁCH</h3>
			</div>
			<div>
				<table class="database-table-user">
					<tr>
						<th class="database-trth-user">Mã sách</th>
						<th class="database-trth-user">Tên sách</th>
						<th class="database-trth-user">Tác giả</th>
						<th class="database-trth-user">Năm xuất bản</th>
						<th class="database-trth-user">Thể loại</th>
					</tr>
					<c:forEach items="${listBook}" var="book">
						<tr>
							<td class="database-td-user">${book.bookID}</td>
							<td class="database-td-user">${book.bookName}</td>
							<td class="database-td-user">${book.bookAuthor}</td>
							<td class="database-td-user">${book.publishYear}</td>
							<td class="database-td-user">${book.bookKind}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>
</section>
<%@ include file="/includes/footerDefault.jsp"%>