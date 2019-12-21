<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Library.Model.User"%>
<%@page import="Library.Model.Employee"%>
<%@ include file="/includes/headerDefault.jsp"%>
<%@ include file="/includes/listIndex.jsp"%>
<section>
	<h1>
		Đăng ký thành công!
	</h1>
	<h1>Mã đăng nhập của bạn là: <%=request.getAttribute("msg")%></h1>
</section>
<%@ include file="/includes/footerDefault.jsp"%>
