/*
 *
 * Date: Apr 15, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tvt.common.ConnectDB;
import com.tvt.common.StringProcess;

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
					s+=","+schedule[i];
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
	
}
