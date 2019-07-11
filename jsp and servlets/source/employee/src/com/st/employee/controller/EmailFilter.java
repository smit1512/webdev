package com.st.employee.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/InsertEmpDetails")
public class EmailFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		if (req.getParameter("email") == "") {
			RequestDispatcher rd = req.getRequestDispatcher("InsertEmpDetails");
			rd.forward(req, res);
		}
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		String email = req.getParameter("email");
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			chain.doFilter(req, res);
		} else {
			String msg = "You have entered an invalid email address!";
			req.setAttribute("msg", msg);
			RequestDispatcher rd = req.getRequestDispatcher("RegisterEmpDetails.jsp");
			rd.forward(req, res);
		}
	}
}
