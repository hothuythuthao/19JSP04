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
	<div class="form-container-search">
		<form method="POST"
			action="<%=request.getContextPath()%>/TraCuuSachServlet"
			onsubmit="return checkSearchValue()">
			<div>
				<h2>TRA CỨU SÁCH</h2>
			</div>
			<div>
				<table class="form-table-search">
					<tr>
						<td><label>Tra cứu sách: </label></td>
						<td><select id="isTitles" name="isTitles">
								<option value="book_name">Tên sách</option>
								<option value="book_id">Mã sách</option>
								<option value="book_author">Tác giả</option>
						</select></td>
						<td><input type="text" name="values"></td>
					</tr>
				</table>
			</div>
			<div class="login-bot">
				<input class="search" type="submit" name="submit" value="Tra cứu">
				<input class="reset" type="reset" name="reset" value="Nhập lại">
			</div>
		</form>
	</div>
</section>
<%@ include file="/includes/footerDefault.jsp"%>