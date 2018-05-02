package com.sayschj.simplemail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String username=null;
		PrintWriter out = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if ("username".equals(name)) {
				username = cookie.getValue();
			}
		}
		out.print("欢迎："+username+"<br/>");
		out.print("<a href='#'>邮件一</a>");
		out.print("<a href='#'>邮件二</a>");
		out.print("<a href='#'>邮件三</a>");
	}
}
