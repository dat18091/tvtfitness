package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tvt.common.ConnectDB;
import com.tvt.model.bean.Equipment;

public class EquipmentDao {
	private Connection conn;

	public List<Equipment> getEquipments(int start, int recordPerPage) {
		conn = ConnectDB.getConnect();
		List<Equipment> equipments = new ArrayList<Equipment>();
		String query = "select * from EQUIPMENT order by equipmentId offset ? rows fetch next ? rows only";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, start);
			pst.setInt(2, recordPerPage);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Equipment equipment = new Equipment();
				equipment.setEquipmentId(rs.getString("equipmentId"));
				equipment.setEquipmentName(rs.getNString("equipmentName"));
				equipment.setEquipmentType(rs.getNString("equipmentType"));
				equipment.setImportDate(rs.getDate("importDate").toLocalDate());
				equipment.setWarrantyDate(rs.getDate("warrantyDate").toLocalDate());
				equipment.setImageUrl(rs.getString("imgUrl"));
				equipment.setStatus(rs.getNString("status"));
				equipment.setCost(rs.getFloat("cost"));
				equipment.setBranchId(rs.getString("branchId"));
				equipments.add(equipment);
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
		return equipments;
	}

	public void insertEquiment(Equipment equip) throws SQLException {
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		String query = "insert into EQUIPMENT values(?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, equip.getEquipmentId());
			pst.setNString(2, equip.getEquipmentName());
			pst.setNString(3, equip.getEquipmentType());
			pst.setDate(4, Date.valueOf(equip.getImportDate()));
			pst.setDate(5, Date.valueOf(equip.getWarrantyDate()));
			pst.setString(6, equip.getImageUrl());
			pst.setNString(7, equip.getStatus());
			pst.setFloat(8, equip.getCost());
			pst.setString(9, equip.getBranchId());
			pst.executeUpdate();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateEquiment(Equipment equip) throws SQLException {
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		String query = "update EQUIPMENT "
				+ "set equipmentName=?, equipmentType=?,importDate=?,warrantyDate=?, status=?,cost=?,branchId=? "
				+ "where equipmentId=? ";
		try {
			pst = conn.prepareStatement(query);

			pst.setNString(1, equip.getEquipmentName());
			pst.setNString(2, equip.getEquipmentType());
			pst.setDate(3, Date.valueOf(equip.getImportDate()));
			pst.setDate(4, Date.valueOf(equip.getWarrantyDate()));
			pst.setNString(5, equip.getStatus());
			pst.setFloat(6, equip.getCost());
			pst.setString(7, equip.getBranchId());
			pst.setString(8, equip.getEquipmentId());
			pst.executeUpdate();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deleteEquipment(String equpmentId) {
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		String query = "delete from EQUIPMENT where equipmentId=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, equpmentId);
			pst.executeUpdate();
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
	}

	public int numberOfRecord() {
		// TODO Auto-generated method stub
		conn = ConnectDB.getConnect();
		int rows = 0;
		String query = "select count(*) from EQUIPMENT";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(query);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				rows = rs.getInt(1);
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
		return rows;
	}

	public Equipment getEquipment(String equipmentId) {
		conn = ConnectDB.getConnect();
		String query = "select * from EQUIPMENT where equipmentId = ?";
		PreparedStatement pst = null;
		Equipment equipment = new Equipment();
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, equipmentId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				equipment.setEquipmentId(rs.getString("equipmentId"));
				equipment.setEquipmentName(rs.getNString("equipmentName"));
				equipment.setEquipmentType(rs.getNString("equipmentType"));
				equipment.setImportDate(rs.getDate("importDate").toLocalDate());
				equipment.setWarrantyDate(rs.getDate("warrantyDate").toLocalDate());
				equipment.setImageUrl(rs.getString("imgUrl"));
				equipment.setStatus(rs.getNString("status"));
				equipment.setCost(rs.getFloat("cost"));
				equipment.setBranchId(rs.getString("branchId"));
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
		return equipment;
	}

}
