/*
 *
 * Date: Apr 20, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.bo;

import java.util.List;

import com.tvt.model.bean.RegisterClass;
import com.tvt.model.dao.RegisterClassDAO;

public class RegisterClassBo {

	RegisterClassDAO registerClassDAO = new RegisterClassDAO();
	
	public void insert(String memberId, String classId, String registerDate, String payStatus) {
		registerClassDAO.insert(memberId, classId, registerDate, payStatus);
	}

	public List<RegisterClass> getAll() {
		return registerClassDAO.getAll();
	}

	public void delete(String classId, String memberId) {
		registerClassDAO.delete(classId, memberId);
	}

}
