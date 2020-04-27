package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.List;

import com.tvt.model.bean.Branch;
import com.tvt.model.bean.Equipment;
import com.tvt.model.dao.EquipmentDao;

public class EquipmentBO {
	private EquipmentDao equipmentDao = new EquipmentDao();

	public List<Equipment> getEquipments(int start, int recordPerPage) {
		return equipmentDao.getEquipments(start, recordPerPage);
	}

	public void insertEquipment(Equipment equipment) throws SQLException {
		equipmentDao.insertEquiment(equipment);
	}

	public void updateEquipment(Equipment equipment) throws SQLException {
		equipmentDao.updateEquiment(equipment);
	}

	public void deleteEquipment(String equipmentId) {
		equipmentDao.deleteEquipment(equipmentId);
	}

	public int numberOfRecord() {
		return equipmentDao.numberOfRecord();
	}

	public Equipment getEquipment(String equipmentId) {
		return equipmentDao.getEquipment(equipmentId);
	}

	public String getBranchName(String branchId) {
		List<Branch> branchs = new BranchBO().getAllBranch();
		for (Branch branch : branchs) {
			String branchID = branch.getBranchId();
			if (branchId.equals(branchID)) {
				return branch.getBranchName();
			}
		}
		return null;
	}

	public int startPosition(int currentPage, int recordPerPage) {
		return currentPage * recordPerPage - recordPerPage;
	}

	public int noOfPage(int rows, int recordPerPage) {
		int nOfPage = rows / recordPerPage;
		if (rows % recordPerPage > 0) {
			nOfPage++;
		}
		return nOfPage;
	}

	public int endPosition(int rows, int start, int recordPerPage) {
		int end = start + recordPerPage;
		if (end > rows) {
			end = rows;
		}
		return end;
	}

}
