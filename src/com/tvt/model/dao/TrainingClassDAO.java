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

public class TrainingClassDAO {
	ConnectDB connectDB = new ConnectDB();
	Connection conn;
	
	public void themLopTap(String classId, String className, String packageName, String memberName, String maxMember,
			String timeStart, String timeEnd, String status) {
		conn=ConnectDB.getConnect();
		String sql = "Insert into CLASS (classId,className,packageId,empId,timeTable,maxMember,timeStart,timeEnd,status,branchId) Values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, classId);
			pstm.setString(2, className);
			pstm.setString(3, packageName);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
