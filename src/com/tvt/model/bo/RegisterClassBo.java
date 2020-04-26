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

	public void delete(String id) {
		registerClassDAO.delete(id);
	}

	public void update(int id, String memberId, String classId, String registerDate, String payStatus) {
		registerClassDAO.update(id, memberId, classId, registerDate, payStatus);
	}

	public RegisterClass layThongTin(int id) {
		return registerClassDAO.layThongTin(id);
	}

}
