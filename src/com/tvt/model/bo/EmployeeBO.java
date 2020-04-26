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

	public List<Employee> getAll(int start, int total, String search, String sortBy) throws SQLException {
		return employeeDAO.getAll(start, total, search, sortBy);
	}

	public void deleteEmployee(String empId) throws SQLException {
		employeeDAO.delete(empId);
	}

	public Employee find(String empId) throws SQLException {
		return employeeDAO.find(empId);
	}

	public void edit(Employee employee) throws SQLException {
		employeeDAO.update(employee);
	}
	
	public List<Employee> getAll() throws SQLException {
		return employeeDAO.getAll();
	}
	
	public int totalPage(int totalRecord, int numberRecordPerPage) {
		return (totalRecord / numberRecordPerPage);
	}

	public int skipRecord(int pageid, int numberRecordPerPage) {
		return (pageid - 1) * numberRecordPerPage;
	}

	public int numberOfPage(int totalRecord, int numberRecordPerPage) {
		int numberOfPage = totalRecord / numberRecordPerPage;
		if (totalRecord % numberRecordPerPage > 0) {
			numberOfPage++;
		}
		return numberOfPage;
	}
}
