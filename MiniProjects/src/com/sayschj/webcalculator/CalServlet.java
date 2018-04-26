package com.sayschj.webcalculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Java EE第一个小项目：在线简易计算器
/*
 * 所涉及的类：CalSrvlet.java、StringUtils.java
 * 服务器：TomCat 8.5
 */
public class CalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置resp、rep的编码格式，避免出现乱码的情况
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String first = req.getParameter("first");
		String second = req.getParameter("second");
		String holder = req.getParameter("holder");
		Integer result = 0;
		//调用StringUtils的方法来判断是否有数据输入
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
		//first和second是字符类型，初始值为null，但我们不希望用户看到的是null，所以，如果他们没有被赋值时用空字符串来代替
		out.print("<input type='number' name='first' value='" + (first == null ? "" : first) + "'/>");
		out.print("<select name=holder>");
		//第一次初始化时，下面的条件语句都不满足if，都会执行else语句完成网页的初始化
		if ("+".equals(holder)) {
			out.print("<option selected='selected'>+</option>");
		} else {//如果没有else，+号将消失
			out.print("<option>+</option>");
		}
		if ("-".equals(holder)) {
			out.print("<option selected='selected'>-</option>");
		} else {
			out.print("<option>-</option>");
		}
		if ("*".equals(holder)) {
			out.print("<option selected='selected'>*</option>");
		} else {
			out.print("<option>*</option>");
		}
		if ("/".equals(holder)) {
			out.print("<option selected='selected'>/</option>");
		} else {
			out.print("<option>/</option>");
		}
		out.print("</select>");
		out.print("<input type='number' name='second' value='" + (second == null ? "" : second) + "'/>");
		out.print("<input type='submit' value='='/>");
		out.print("<input type='text' name='result' value='" + result + "'/>");
	}
}
