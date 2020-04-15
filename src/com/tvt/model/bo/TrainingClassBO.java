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

	public void themLopTap(String classId, String className, String packageName, String memberName, String timeTable,
			String maxMember, String timeStart, String timeEnd) {
		trainingClassDAO.themLopTap(classId, className, packageName, memberName, timeTable, maxMember, timeStart,
				timeEnd);
	}

}
