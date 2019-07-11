package com.st.employee.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class MyListener implements ServletContextListener {
	Logger logger = LoggerFactory.getLogger(InsertEmpDetails.class);
	public void contextInitialized(ServletContextEvent e) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "smit");
			ServletContext ctx = e.getServletContext();
			ctx.setAttribute("mycon", con);
			logger.info("JDBC connection done");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void contextDestroyed(ServletContextEvent e) {
		logger.info("context destroyed");
	}
}