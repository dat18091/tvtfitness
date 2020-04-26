/*
 *
 * Date: Apr 23, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.bo;

import java.util.List;

import com.tvt.model.bean.RegisterService;
import com.tvt.model.dao.RegisterServiceDAO;

public class RegisterServiceBO {

	RegisterServiceDAO registerServiceDAO = new RegisterServiceDAO();

	public void insert(String maDv, String maTv, String registerDate, String chiPhi) {
		registerServiceDAO.insert(maDv, maTv, registerDate, chiPhi);
	}

	public List<RegisterService> getAll() {
		return registerServiceDAO.getAll();
	}

	public void delete(String id) {
		registerServiceDAO.delete(id);
	}

	public void update(int id, String maDv, String maTv, String registerDate, String chiPhi) {
		registerServiceDAO.update(id, maDv, maTv, registerDate, chiPhi);
	}

	public RegisterService layThongTin(int id) {
		return registerServiceDAO.layThongTin(id);
	}
	
	
	
}
