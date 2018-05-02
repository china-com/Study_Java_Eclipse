package com.sayschj.simplemail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Cookie c = new Cookie("username", username);
		resp.addCookie(c);
		if ("admin".equals(username) && "123456".equals(password)) {
			out.print("ª∂”≠£∫" + username + "<br/>");
			out.print("<a href='/MiniProjects/list'> ’º˛œ‰(3)</a>");
		}
	}
}
