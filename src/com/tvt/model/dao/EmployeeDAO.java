/**
 * 
 */
package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tvt.model.bean.Employee;

/**
 * @author Quoc
 *
 */
public class EmployeeDAO implements IDAOBase<Employee> {

	@Override
	public List<Employee> getAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = com.tvt.common.ConnectDB.getConnect();

			String sql = "select empId, empName, numberPhone, birthday, imgUrl, branchId, accountId from EMPLOYEE";

			pstm = conn.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();
			List<Employee> list = new ArrayList<Employee>();
			while (rs.next()) {
				String empId = rs.getString("empId");
				String empName = rs.getString("empName");
				String numberPhone = rs.getString("numberPhone");
				LocalDate birthday = rs.getDate("birthday").toLocalDate();
				String imgUrl = rs.getString("imgUrl");
				String branchId = rs.getString("branchId");
				String accountId = rs.getString("accountId");

				Employee employee = new Employee();
				employee.setEmpId(empId);
				employee.setEmpName(empName);
				employee.setNumberPhone(numberPhone);
				employee.setBirthday(birthday);
				employee.setImg(imgUrl);
				employee.setBranchId(branchId);
				employee.setAccountId(accountId);
				list.add(employee);
			}

			return list;
		} finally {
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}

	@Override
	public void insert(Employee employee) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = com.tvt.common.ConnectDB.getConnect();
			String sql = "insert into EMPLOYEE(empId, empName, numberPhone, birthday, imgUrl, branchId, accountId) values (?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, employee.getEmpId());
			pstm.setString(2, employee.getEmpName());
			pstm.setString(3, employee.getNumberPhone());
			pstm.setDate(4, Date.valueOf(employee.getBirthday()));
			pstm.setString(5, employee.getImg());
			pstm.setString(6, employee.getBranchId());
			pstm.setString(7, employee.getAccountId());

			pstm.executeUpdate();
		} finally {
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}

	@Override
	public void update(Employee employee) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = com.tvt.common.ConnectDB.getConnect();
			String sql = "update EMPLOYEE set empName = ?, numberPhone = ?, birthday = ?, imgUrl = ?, branchId = ?, accountId = ? where empId = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, employee.getEmpName());
			pstm.setString(2, employee.getNumberPhone());
			pstm.setDate(3, Date.valueOf(employee.getBirthday()));
			pstm.setString(4, employee.getImg());
			pstm.setString(5, employee.getBranchId());
			pstm.setString(6, employee.getAccountId());
			pstm.setString(7, employee.getEmpId());

			pstm.executeUpdate();
		} finally {
			// TODO: handle finally clause
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}

	@Override
	public void delete(String empId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = com.tvt.common.ConnectDB.getConnect();
			String sql = "delete from EMPLOYEE where empId = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, empId);

			pstm.executeUpdate();
		} finally {
			// TODO: handle finally clause
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}

	@Override
	public Employee find(String empId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = com.tvt.common.ConnectDB.getConnect();
			String sql = "select empId, empName, numberPhone, birthday, imgUrl, branchId, accountId where empId = ?";

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, empId);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				String empName = rs.getString("empName");
				String numberPhone = rs.getString("numberPhone");
				LocalDate birthday = rs.getDate("birthday").toLocalDate();
				String img = rs.getString("imgUrl");
				String branchId = rs.getString("branchId");
				String accountId = rs.getString("accountId");
				Employee employee = new Employee(empId, empName, numberPhone, birthday, img, branchId, accountId);
				return employee;
			}
			return null;
		} finally {
			// TODO: handle finally clause
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}

}
