<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>
		<%=request.getAttribute("msg")%>
	</h1>
</section>
<%@ include file="/includes/footerDefault.jsp"%>