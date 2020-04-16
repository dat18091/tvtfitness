package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.List;

import com.tvt.model.bean.Equipment;
import com.tvt.model.bean.EquipmentDao;

public class EquipmentBO {
	private EquipmentDao equipmentDao= new EquipmentDao();
	
	public List<Equipment> getEquipments() throws SQLException{
		return equipmentDao.getEquipments();
	}
	
	public boolean insertEquipment(Equipment equipment) throws SQLException{
		return equipmentDao.insertEquipment(equipment);
	}
	
	public boolean updateEquipment(Equipment equipment) throws SQLException{
		return equipmentDao.updateEquipment(equipment);
	}
	
	public boolean deleteEquipment(String equipmentId) throws SQLException{
		return equipmentDao.deleteEquipment(equipmentId);
	}

}
