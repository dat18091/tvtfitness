/*
 *
 * Date: Apr 23, 2020
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
import com.tvt.model.bean.RegisterService;

public class RegisterServiceDAO {

	ConnectDB connectDB = new ConnectDB();
	Connection conn;

	public void insert(String maDv, String maTv, String registerDate, String chiPhi) {
		String sql = "INSERT INTO REGISTER_SERVICE (serviceId,memberId,timeOfPurchase,amount) VALUES (?,?,?,?)";
		conn = connectDB.getConnect();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, maDv);
			pstm.setString(2, maTv);
			pstm.setDate(3, Date.valueOf(registerDate));
			pstm.setFloat(4, Float.parseFloat(chiPhi));
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<RegisterService> getAll() {
		conn = ConnectDB.getConnect();
		String sql = "SELECT registerServiceId, serviceId, memberId, timeOfPurchase, amount FROM REGISTER_SERVICE ";
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<RegisterService> list = new ArrayList<RegisterService>();
		RegisterService registerService;
		try {
			while (resultSet.next()) {
				registerService = new RegisterService();
				registerService.setRegisterServiceId(resultSet.getInt("registerServiceId"));
				registerService.setServiceId(resultSet.getString("serviceId"));
				;
				registerService.setMemberId(resultSet.getString("memberId"));
				registerService.setTimeOfPurchase(resultSet.getDate("timeOfPurchase").toLocalDate());
				registerService.setAmount(resultSet.getFloat("amount"));
				list.add(registerService);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public void delete(String id) {
		conn = ConnectDB.getConnect();
		String sql = "DELETE FROM REGISTER_SERVICE where registerServiceId = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt(id));
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public RegisterService layThongTin(int id) {
		conn = ConnectDB.getConnect();
		String sql = String.format("SELECT * from REGISTER_SERVICE where registerServiceId = %d", id);
		ResultSet rs = null;
		try {
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RegisterService registerClass = null;
		try {
			if (rs.next()) {
				registerClass = new RegisterService();
				registerClass.setRegisterServiceId(rs.getInt("registerServiceId"));
				registerClass.setServiceId(rs.getString("serviceId"));
				registerClass.setMemberId(rs.getString("memberId"));
				registerClass.setTimeOfPurchase(rs.getDate("timeOfPurchase").toLocalDate());
				registerClass.setAmount(rs.getFloat("amount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registerClass;
	}

	public void update(int id, String maDv, String maTv, String registerDate, String chiPhi) {
		conn = ConnectDB.getConnect();
		String sql = "UPDATE REGISTER_SERVICE SET serviceId = ?, memberId = ?, timeOfPurchase = ?, amount = ? WHERE registerServiceId = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, maDv);
			pstm.setString(2, maTv);
			pstm.setDate(3, Date.valueOf(registerDate));
			pstm.setFloat(4, Float.parseFloat(chiPhi));
			pstm.setInt(5, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
