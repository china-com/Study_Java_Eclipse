<%@page import="java.util.Date"%>
<%@page import="java.awt.image.DataBuffer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际化标签（标准标签库）</title>
</head>
<body>
	<!-- 设置国际化资源文件的基本名称 -->
	<fmt:setBundle basename="app"/>
	<form action="#">
	<fmt:message key="username"/><input name="username"/><br/>
	<fmt:message key="password"/><input name="password"/><br/>
	<input type="submit" value='login' /><br/>
	</form>
	<%
		Date d=new Date();
		request.setAttribute("date", d);
	%>
	<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH-mm-ss"/>
</body>
</html>