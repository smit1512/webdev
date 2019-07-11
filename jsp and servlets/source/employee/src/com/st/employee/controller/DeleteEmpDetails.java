package com.st.employee.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.st.employee.service.EmployeeService;

@WebServlet("/DeleteEmpDetails")
public class DeleteEmpDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(InsertEmpDetails.class);

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("id"));
		EmployeeService empService = new EmployeeService();
		try {
			empService.deleteEmployee(id);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			String err = "Error in delete operation";
			req.setAttribute("err",err);
		}
		RequestDispatcher rd = req.getRequestDispatcher("DisplayEmpDetails");
		rd.forward(req, res);
	}
}