package com.st.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.st.employee.controller.InsertEmpDetails;
public class EmployeeConnection
{
	static Logger logger = LoggerFactory.getLogger(InsertEmpDetails.class);
	static Connection con;
	private EmployeeConnection()
	{
		logger.info("Object cannot be created for this class");
	}
	public static synchronized Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "smit");

			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}
		}
		return con;
	}
}
