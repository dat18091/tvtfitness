/*
 *
 * Date: Apr 15, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.bo;

import java.util.List;

import com.tvt.model.bean.TrainingClass;
import com.tvt.model.dao.TrainingClassDAO;

public class TrainingClassBO {

	TrainingClassDAO trainingClassDAO = new TrainingClassDAO();

	public void insert(String classId, String className, String packageId, String empId, String[] schedule,
			int maxMember, String dateStart, String dateEnd, String status, String branchId) {
		trainingClassDAO.insert(classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd, status,
				branchId);
	}

	public List<TrainingClass> getAll() {
		return trainingClassDAO.getAll();
	}

	public void update(String classId, String className, String packageId, String empId, String[] schedule,
			int maxMember, String dateStart, String dateEnd, String status, String branchId) {
		trainingClassDAO.update(classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd, status,
				branchId);
	}

	public void deleteById(String classId) {
		trainingClassDAO.deleteById(classId);
	}

	public List<TrainingClass> getClasses(int start, int recordPerPage) {
		return trainingClassDAO.getClassList(start, recordPerPage);
	}

	public List<TrainingClass> getClasses(int start, int recordPerPage, String search, String sort) {

		if (search != null && !"".equals(search)) { // Lay danh sach tim kiem
			return trainingClassDAO.search(search);
		} else if (sort != null && !"".equals(sort)) { // Lay danh sach sap xep
			return trainingClassDAO.sortList(sort);
		} else {
			return trainingClassDAO.getClassList(start, recordPerPage); // Lay danh sach toan bo
		}

	}

	public int numberOfRecord() {
		return trainingClassDAO.numberOfRecords(); // Lay do dai danh sach
	}

	public int noOfPage(int rows, int recordPerPage) {
		int nOfPage = rows / recordPerPage;
		if (rows % recordPerPage > 0) {
			nOfPage++;
		}
		return nOfPage;
	}

	public int startPosition(int currentPage, int recordPerPage) {
		return currentPage * recordPerPage - recordPerPage;
	}

	public int endPosition(int rows, int start, int recordPerPage) {
		int end = start + recordPerPage + 1;
		if (end > rows) {
			end = rows;
		}
		return end;
	}

	public TrainingClass searchById(String classId) {
		return trainingClassDAO.searchById(classId);
	}

}
