package com.st.employee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.st.employee.model.Employee;
import com.st.employee.service.EmployeeService;

@WebServlet("/DisplayEmpDetails")
public class DisplayEmpDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(InsertEmpDetails.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		EmployeeService empservice = new EmployeeService();
		List<Employee> empList;
		try {
			empList = empservice.getEmployees();
			req.setAttribute("obj", empList);
			RequestDispatcher rd = req.getRequestDispatcher("Display.jsp");
			rd.include(req, res);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			String err = "Error in displaying";
			req.setAttribute("err",err);
			RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
			rd.forward(req, res);
		}
	}
}
