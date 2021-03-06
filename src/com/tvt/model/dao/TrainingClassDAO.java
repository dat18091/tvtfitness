/*
 *
 * Date: Apr 15, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tvt.common.ConnectDB;
import com.tvt.model.bean.TrainingClass;

public class TrainingClassDAO {

	ConnectDB connectDB = new ConnectDB();
	Connection conn;

	public void insert(String classId, String className, String packageId, String empId, String[] schedule,
			int maxMember, String dateStart, String dateEnd, String status, String branchId) {
		conn = ConnectDB.getConnect();
		String sql = "Insert into CLASS (classId,className,packageId,empId,schedule,maxMember,dateStart,dateEnd,status,branchId) Values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, classId);
			pstm.setNString(2, className);
			pstm.setString(3, packageId);
			pstm.setString(4, empId);

			String s = schedule[0];
			for (int i = 1; i < schedule.length; i++) {
				s += "," + schedule[i];
			}
			pstm.setNString(5, s);

			pstm.setInt(6, maxMember);
			pstm.setDate(7, Date.valueOf(dateStart));
			pstm.setDate(8, Date.valueOf(dateStart));
			pstm.setNString(9, status);
			pstm.setString(10, branchId);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<TrainingClass> getAll() {
		conn = ConnectDB.getConnect();
		String sql = "SELECT classId, className, packageName, empName, schedule, maxMember, dateStart, dateEnd, status, branchName"
				+ " FROM CLASS a, BRANCH b, EMPLOYEE c, PACKAGE d "
				+ "WHERE a.branchId = b.branchId AND a.empId = c.empId AND a.packageId = d.packageId";
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<TrainingClass> listClasses = new ArrayList<TrainingClass>();
		TrainingClass trainingClass;
		try {
			while (resultSet.next()) {
				trainingClass = new TrainingClass();
				trainingClass.setClassId(resultSet.getString("classId"));
				trainingClass.setClassName(resultSet.getNString("className"));
				trainingClass.setPackageId(resultSet.getNString("packageName"));
				trainingClass.setEmpId(resultSet.getNString("empName"));
				trainingClass.setSchedule(resultSet.getNString("schedule"));
				trainingClass.setMaxMember(resultSet.getInt("maxMember"));
				trainingClass.setDateStart(resultSet.getDate("dateStart").toLocalDate());
				trainingClass.setDateEnd(resultSet.getDate("dateEnd").toLocalDate());
				trainingClass.setStatus(resultSet.getNString("status"));
				trainingClass.setBranchId(resultSet.getNString("branchName"));
				listClasses.add(trainingClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClasses;
	}

	public void update(String classId, String className, String packageId, String empId, String[] schedule,
			int maxMember, String dateStart, String dateEnd, String status, String branchId) {
		conn = ConnectDB.getConnect();
		String sql = "UPDATE CLASS SET className = ?, packageId = ?, empId = ?, schedule = ?, maxMember = ?, dateStart = ?, dateEnd = ?,status = ?,branchId = ? WHERE classId = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setNString(1, className);
			pstm.setString(2, packageId);
			pstm.setString(3, empId);

			String s = schedule[0];
			for (int i = 1; i < schedule.length; i++) {
				s += "," + schedule[i];
			}
			pstm.setNString(4, s);

			pstm.setInt(5, maxMember);
			pstm.setDate(6, Date.valueOf(dateStart));
			pstm.setDate(7, Date.valueOf(dateStart));
			pstm.setNString(8, status);
			pstm.setString(9, branchId);
			pstm.setString(10, classId);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<TrainingClass> search(String search) {
		conn = ConnectDB.getConnect();
		String sql = String.format(
				"SELECT classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd, status, branchId FROM CLASS"
						+ " WHERE classId LIKE '%s'",
				search);

		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<TrainingClass> list = new ArrayList<TrainingClass>();
		TrainingClass trainingClass = null;
		try {
			while (resultSet.next()) {
				trainingClass = new TrainingClass();
				trainingClass.setClassId(resultSet.getString("classId"));
				trainingClass.setClassName(resultSet.getNString("className"));
				trainingClass.setPackageId(resultSet.getString("packageId"));
				trainingClass.setEmpId(resultSet.getString("empId"));
				trainingClass.setSchedule(resultSet.getNString("schedule"));
				trainingClass.setMaxMember(resultSet.getInt("maxMember"));
				trainingClass.setDateStart(resultSet.getDate("dateStart").toLocalDate());
				trainingClass.setDateEnd(resultSet.getDate("dateEnd").toLocalDate());
				trainingClass.setStatus(resultSet.getNString("status"));
				trainingClass.setBranchId(resultSet.getString("branchId"));
				list.add(trainingClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void deleteById(String classId) {
		conn = ConnectDB.getConnect();
		String sql = "DELETE FROM CLASS where classId = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, classId);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<TrainingClass> getClassList(int start, int recordPerPage) {
		conn = ConnectDB.getConnect();
		String sql = String.format(
				"SELECT classId, className, packageName, empName, schedule, maxMember, dateStart, dateEnd, status, branchName"
						+ " FROM CLASS a, BRANCH b, EMPLOYEE c, PACKAGE d "
						+ "WHERE a.branchId = b.branchId AND a.empId = c.empId AND a.packageId = d.packageId "
						+ "order by classId offset %d rows fetch next %d rows only",
				start, recordPerPage);
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<TrainingClass> listClasses = new ArrayList<TrainingClass>();
		TrainingClass trainingClass;
		try {
			while (resultSet.next()) {
				trainingClass = new TrainingClass();
				trainingClass.setClassId(resultSet.getString("classId"));
				trainingClass.setClassName(resultSet.getNString("className"));
				trainingClass.setPackageId(resultSet.getNString("packageName"));
				trainingClass.setEmpId(resultSet.getNString("empName"));
				trainingClass.setSchedule(resultSet.getNString("schedule"));
				trainingClass.setMaxMember(resultSet.getInt("maxMember"));
				trainingClass.setDateStart(resultSet.getDate("dateStart").toLocalDate());
				trainingClass.setDateEnd(resultSet.getDate("dateEnd").toLocalDate());
				trainingClass.setStatus(resultSet.getNString("status"));
				trainingClass.setBranchId(resultSet.getNString("branchName"));
				listClasses.add(trainingClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClasses;
	}

	public int numberOfRecords() {
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement("select count(*) from CLASS");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return row;

	}

	public List<TrainingClass> sortList(String sort) {
		conn = ConnectDB.getConnect();
		String sql = String.format(
				"SELECT classId, className, packageName, empName, schedule, maxMember, dateStart, dateEnd, status, branchName"
						+ " FROM CLASS a, BRANCH b, EMPLOYEE c, PACKAGE d "
						+ "WHERE a.branchId = b.branchId AND a.empId = c.empId AND a.packageId = d.packageId "
						+ "order by classId %s",sort);
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<TrainingClass> listClasses = new ArrayList<TrainingClass>();
		TrainingClass trainingClass;
		try {
			while (resultSet.next()) {
				trainingClass = new TrainingClass();
				trainingClass.setClassId(resultSet.getString("classId"));
				trainingClass.setClassName(resultSet.getNString("className"));
				trainingClass.setPackageId(resultSet.getNString("packageName"));
				trainingClass.setEmpId(resultSet.getNString("empName"));
				trainingClass.setSchedule(resultSet.getNString("schedule"));
				trainingClass.setMaxMember(resultSet.getInt("maxMember"));
				trainingClass.setDateStart(resultSet.getDate("dateStart").toLocalDate());
				trainingClass.setDateEnd(resultSet.getDate("dateEnd").toLocalDate());
				trainingClass.setStatus(resultSet.getNString("status"));
				trainingClass.setBranchId(resultSet.getNString("branchName"));
				listClasses.add(trainingClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClasses;
	}

	public TrainingClass searchById(String classId) {
		conn = ConnectDB.getConnect();
		String sql = String.format(
				"SELECT classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd, status, branchId FROM CLASS WHERE classId = '%s' ",
				classId);
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TrainingClass trainingClass = null;
		try {
			if (resultSet.next()) {
				trainingClass = new TrainingClass();
				trainingClass.setClassId(resultSet.getString("classId"));
				trainingClass.setClassName(resultSet.getNString("className"));
				trainingClass.setPackageId(resultSet.getString("packageId"));
				trainingClass.setEmpId(resultSet.getString("empId"));
				trainingClass.setSchedule(resultSet.getNString("schedule"));
				trainingClass.setMaxMember(resultSet.getInt("maxMember"));
				trainingClass.setDateStart(resultSet.getDate("dateStart").toLocalDate());
				trainingClass.setDateEnd(resultSet.getDate("dateEnd").toLocalDate());
				trainingClass.setStatus(resultSet.getNString("status"));
				trainingClass.setBranchId(resultSet.getString("branchId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trainingClass;
	}

}
