/*
 *
 * Date: Apr 23, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.bo;

import com.tvt.model.dao.RegisterServiceDAO;

public class RegisterServiceBO {

	RegisterServiceDAO registerServiceDAO = new RegisterServiceDAO();

	public void insert(String maDv, String maTv, String registerDate, String chiPhi) {
		registerServiceDAO.insert(maDv, maTv, registerDate, chiPhi);
	}

}
