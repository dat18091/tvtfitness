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
			int maxMember, String dateStart, String dateEnd,String status, String branchId) {
		trainingClassDAO.insert(classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd,status,
				branchId);
	}

	public List<TrainingClass> getAll() {
		return trainingClassDAO.getAll();
	}

	public void update(String classId, String className, String packageId, String empId, String[] schedule,
			int maxMember, String dateStart, String dateEnd,String status, String branchId) {
		trainingClassDAO.update(classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd,status,
				branchId);
	}

	public TrainingClass searchById(String classId) {
		return trainingClassDAO.searchById(classId);
	}

	public void deleteById(String classId) {
		trainingClassDAO.deleteById(classId);
	}

}
