<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Integer age = 17;
		request.setAttribute("age", age);
	%>
	<br /> 年龄是否大于18
	<c:if test="${age>=18 }" var="ret" scope="page">
	满足条件
	</c:if>
	<br /> 判断的结果：${ret }
	<br />
	<!-- 在页面中输出1 2 3 4 5 ... -->
	<c:forEach var="num" begin="1" end="10">
	${pageScope.num }
	</c:forEach>
	<hr />
	<%
		List<String> list = Arrays.asList(new String[] { "Hello", "World", "Chj" });
		request.setAttribute("list", list);
	%>
	<c:forEach items="${list }" var="item" varStatus="vs">
	${vs.count }--->{pageScope.item}<br />
	</c:forEach>
</body>
</html>