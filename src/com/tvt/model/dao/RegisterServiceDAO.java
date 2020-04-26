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
import java.sql.SQLException;
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
		return null;
	}
	
	public void update(String id) {
		
	}
	
	public void delete(String id) {
		
	}
}
