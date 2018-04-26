package com.sayschj.miniprojects;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Java EE��һ��С��Ŀ�����߼��׼�����
/*
 * ���漰���ࣺCalSrvlet.java��StringUtils.java
 * ��������TomCat 8.0
 */
public class CalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String first = req.getParameter("first");
		String second = req.getParameter("second");
		String holder = req.getParameter("holder");
		Integer result = 0;
		if (StringUtils.hasLength(first) && StringUtils.hasLength(second)) {
			Integer iFirst = Integer.valueOf(first);
			Integer iSecond = Integer.valueOf(second);
			if ("+".equals(holder)) {
				result = iFirst + iSecond;
			} else if ("-".equals(holder)) {
				result = iFirst - iSecond;
			} else if ("*".equals(holder)) {
				result = iFirst * iSecond;
			} else if ("/".equals(holder)) {
				result = iFirst / iSecond;
			}
		}

		PrintWriter out = resp.getWriter();
		out.print("<form action='/MiniProjects/CalServlet' method='post'>");
		out.print("<input type='number' name='first' value='" + (first == null ? "" : first) + "'/>");
		out.print("<select name=holder>");
		if ("+".equals(holder)) {
			out.print("<option selected='selected'>+</option>");
		} else {//���û��else��+�Ž���ʧ
			out.print("<option>+</option>");
		}
		if ("-".equals(holder)) {
			out.print("<option selected='selected'>-</option>");
		} else {//���û��else��+�Ž���ʧ
			out.print("<option>-</option>");
		}
		if ("*".equals(holder)) {
			out.print("<option selected='selected'>*</option>");
		} else {//���û��else��+�Ž���ʧ
			out.print("<option>*</option>");
		}
		if ("/".equals(holder)) {
			out.print("<option selected='selected'>/</option>");
		} else {//���û��else��+�Ž���ʧ
			out.print("<option>/</option>");
		}
		out.print("</select>");
		out.print("<input type='number' name='second' value='" + (second == null ? "" : second) + "'/>");
		out.print("<input type='submit' value='='/>");
		out.print("<input type='text' name='result' value='" + result + "'/>");
	}
}
