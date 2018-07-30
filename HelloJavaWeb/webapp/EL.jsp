<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 在四大作用域中存放共享数据 -->
	<%
		pageContext.setAttribute("msg", "pageContext");
		request.setAttribute("msg", "request");
		session.setAttribute("msg", "session");
		application.setAttribute("msg", "application");
	%>
	<!-- 在四大作用域中取出共享数据 -->
	pageContext:<%=pageContext.getAttribute("msg") %> <br />
	request:<%=request.getAttribute("msg")%><br />
	session:<%=session.getAttribute("msg")%><br />
	application:<%=application.getAttribute("msg")%><br />
	<hr/>
	<!-- 从四大作用域里获取数据，如果没找到（null）则返回空字符串，找到则返回找到的字段 -->
	<%=pageContext.findAttribute("msg")==null?"":pageContext.findAttribute("msg") %>
	<!-- El表达式 ，从作用域中获取共享的数据，类于上面的表达式，简写-->
	${msg }
	<hr/>
	pageContext:${pageScope.msg} <br/>
	request:${requestScope.msg } <br/>
	session:${sessionScope.msg } <br/>
	application:${applicationScope.msg }
</body>
</html>