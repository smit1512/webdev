package com.st.employee.service;

import java.sql.SQLException;
import java.util.List;

import com.st.employee.dao.EmployeeDao;
import com.st.employee.model.Employee;

public class EmployeeService {
	EmployeeDao empdao = new EmployeeDao();

	public List<Employee> getEmployees() throws SQLException {
		List<Employee> empList = empdao.getEmployees();
		return empList;
	}

	public void insertEmployee(String name, String email, double pno) throws SQLException {
		empdao.insertEmployee(name, email, pno);
	}

	public void updateEmployee(String name, String email, double pno, int id) throws SQLException {
		empdao.updateEmployee(name, email, pno, id);
	}

	public void deleteEmployee(int id) throws SQLException {
		empdao.deleteEmployee(id);
	}

	public Employee getEmp(int id) throws SQLException {
		Employee e = empdao.getEmp(id);
		return e;
	}
}
