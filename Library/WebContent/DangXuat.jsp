<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Library.Model.User"%>
<%@page import="Library.Model.Employee"%>
<%@ include file="/includes/headerDefault.jsp"%>
<%@ include file="/includes/listIndex.jsp"%>
<section>
	<h1>
		Thông báo:
		<%=request.getAttribute("msg")%>
	</h1>
</section>
<%@ include file="/includes/footerDefault.jsp"%>
