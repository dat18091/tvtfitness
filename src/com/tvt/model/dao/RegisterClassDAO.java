/*
 *
 * Date: Apr 20, 2020
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
import com.tvt.model.bean.RegisterClass;

public class RegisterClassDAO {

	ConnectDB connectDB = new ConnectDB();
	Connection conn;

	public void insert(String memberId, String classId, String registerDate, String payStatus) {
		conn = ConnectDB.getConnect();
		String sql = "Insert into REGISTER_CLASS (memberId, classId, registerDate, payStatus) Values (?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, memberId);
			pstm.setString(2, classId);
			pstm.setDate(3, Date.valueOf(registerDate));
			pstm.setNString(4, payStatus);

			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<RegisterClass> getAll() {
		conn = ConnectDB.getConnect();
		String sql = "SELECT memberId, classId, registerDate, payStatus FROM REGISTER_CLASS ";
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<RegisterClass> list = new ArrayList<RegisterClass>();
		RegisterClass registerClass;
		try {
			while (resultSet.next()) {
				registerClass = new RegisterClass();
				registerClass.setMemberId(resultSet.getString("memberId"));
				registerClass.setClassId(resultSet.getString("classId"));
				registerClass.setRegisterDate(resultSet.getDate("registerDate").toLocalDate());
				registerClass.setPayStatus(resultSet.getNString("payStatus"));
				list.add(registerClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void delete(String classId, String memberId) {
		conn = ConnectDB.getConnect();
		String sql = "DELETE FROM REGISTER_CLASS where classId = ? AND memberId = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, classId);
			pstm.setString(2, memberId);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
