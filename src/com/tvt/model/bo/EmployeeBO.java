package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.List;

import com.tvt.model.bean.Employee;

/**
 * @author Quoc
 *
 */

import com.tvt.model.dao.EmployeeDAO;

public class EmployeeBO {
	EmployeeDAO employeeDAO = new EmployeeDAO();

	public void insertEmployee(Employee employee) throws SQLException {
		employeeDAO.insert(employee);
	}

	public List<Employee> getAll() throws SQLException {
		return employeeDAO.getAll();
	}

	public void deleteMember(String empId) throws SQLException {
		employeeDAO.delete(empId);
	}

	public Employee find(String empId) throws SQLException {
		return employeeDAO.find(empId);
	}

	public void edit(Employee employee) throws SQLException {
		employeeDAO.update(employee);
	}
}
