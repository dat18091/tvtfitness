/*
 *
 * Date: Apr 15, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.bo;

import com.tvt.model.dao.TrainingClassDAO;

public class TrainingClassBO {

	TrainingClassDAO trainingClassDAO = new TrainingClassDAO();

	public void insert(String classId, String className, String packageId, String empId, String[] schedule,
			int maxMember, String dateStart, String dateEnd, String branchId) {
		trainingClassDAO.insert(classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd, branchId);
	}

}
