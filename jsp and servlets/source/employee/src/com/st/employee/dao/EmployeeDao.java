package com.st.employee.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.st.employee.model.Employee;

public class EmployeeDao {
	public List<Employee> getEmployees() throws SQLException {
		String sql = "select * from employee";
		List<Employee> empList = new ArrayList<>();
		Connection con = EmployeeConnection.getConnection();
		Statement empQuery = con.createStatement();
		ResultSet emplAllData = empQuery.executeQuery(sql);
		while (emplAllData.next()) {
			int empId = emplAllData.getInt(1);
			String empName = emplAllData.getString(2);
			String empEmail = emplAllData.getString(3);
			Double empNo = emplAllData.getDouble(4);
			String phoneNo = BigDecimal.valueOf(empNo).toPlainString();
			Employee employee = new Employee();
			employee.setEmployeeId(empId);
			employee.setName(empName);
			employee.setEmail(empEmail);
			employee.setContactNo(phoneNo);
			empList.add(employee);
		}
		return empList;
	}

	public void insertEmployee(String name, String email, double pno) throws SQLException {
		String sql = "insert into employee (e_name,email,phone) values ('" + name + "','" + email + "'," + pno + ")";
		Connection con = EmployeeConnection.getConnection();
		Statement insertStmt = con.createStatement();
		insertStmt.executeUpdate(sql);
	}

	public void updateEmployee(String name, String email, double pno, int id) throws SQLException {
		String sql = "update employee set e_name='" + name + "',email='" + email + "',phone=" + pno + " where id=" + id;
		Connection con = EmployeeConnection.getConnection();
		Statement updateStmt = con.createStatement();
		updateStmt.executeUpdate(sql);
	}

	public void deleteEmployee(int id) throws SQLException {
		String sql = "delete from employee where id="+id;
		Connection con = EmployeeConnection.getConnection();
		Statement deleteStmt = con.createStatement();
		deleteStmt.executeUpdate(sql);
	}

	public Employee getEmp(int id) throws SQLException {
		String sql = "select * from employee where id=" + id;
		Employee emp = new Employee();
		Connection con = EmployeeConnection.getConnection();
		Statement getEmpStmt = con.createStatement();
		ResultSet rs = getEmpStmt.executeQuery(sql);
		while (rs.next()) {
			int empId = rs.getInt(1);
			String empName = rs.getString(2);
			String email = rs.getString(3);
			Double no = rs.getDouble(4);
			String phoneNo = BigDecimal.valueOf(no).toPlainString();
			emp.setEmployeeId(empId);
			emp.setName(empName);
			emp.setEmail(email);
			emp.setContactNo(phoneNo);
		}
		return emp;
	}
}
