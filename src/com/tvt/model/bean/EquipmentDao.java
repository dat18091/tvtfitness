package com.tvt.model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tvt.common.ConnectDB;

public class EquipmentDao {
	private Connection conn;

	public List<Equipment> getEquipments() throws SQLException{
		List<Equipment> equipments= new ArrayList<Equipment>();
		conn= ConnectDB.getConnect();
		PreparedStatement pst = null;
		try {
			pst= conn.prepareStatement("select * from EQUIPMENT");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				
			}
		}finally {
			pst.close();
			conn.close();
		}
		return equipments;
	}

	public boolean insertEquipment(Equipment equipment) throws SQLException{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateEquipment(Equipment equipment) throws SQLException{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteEquipment(String equipmentId) throws SQLException{
		// TODO Auto-generated method stub
		return false;
	}

}
