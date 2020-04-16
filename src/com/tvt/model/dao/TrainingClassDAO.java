/*
 *
 * Date: Apr 15, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tvt.common.ConnectDB;
import com.tvt.common.StringProcess;
import com.tvt.model.bean.TrainingClass;

public class TrainingClassDAO {

	ConnectDB connectDB = new ConnectDB();
	Connection conn;
	StringProcess stringProcess = new StringProcess();

	public void insert(String classId, String className, String packageId, String empId, String[] schedule,
			int maxMember, String dateStart, String dateEnd, String branchId) {
		conn = ConnectDB.getConnect();
		String sql = "Insert into CLASS (classId,className,packageId,empId,schedule,maxMember,dateStart,dateEnd,branchId) Values (?,?,?,?,?,?,?,?,?)";
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
			pstm.setDate(7, stringProcess.stringToDate(dateStart));
			pstm.setDate(8, stringProcess.stringToDate(dateEnd));
			pstm.setString(9, branchId);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<TrainingClass> getAll() {
		conn = ConnectDB.getConnect();
		String sql = "SELECT classId,className,packageId,empId,schedule,maxMember,dateStart,dateEnd,branchId FROM CLASS";
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<TrainingClass> listClasses = new ArrayList<TrainingClass>();
		TrainingClass trainingClass;
		try {
			while (resultSet.next()) {
				trainingClass = new TrainingClass();
				trainingClass.setClassId(resultSet.getString("classId"));
				trainingClass.setClassName(resultSet.getNString("className"));
				trainingClass.setPackageId(resultSet.getString("packageId"));
				trainingClass.setSchedule(resultSet.getNString("schedule"));
				trainingClass.setMaxMember(resultSet.getInt("maxMember"));
//				trainingClass.setDateStart(resultSet.getDate("dateStart"));
//				trainingClass.setDateEnd(resultSet.getDate("dateEnd"));
				trainingClass.setBranchId(resultSet.getString("branchId"));
				listClasses.add(trainingClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClasses;
	}

}
