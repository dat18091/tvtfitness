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

	public void themLopTap(String classId, String className, String packageName, String memberName, String maxMember,
			String timeStart, String timeEnd, String status) {
		trainingClassDAO.themLopTap(classId, className, packageName, memberName, maxMember, timeStart, timeEnd, status);
	}

}
