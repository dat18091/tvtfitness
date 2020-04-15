/**
 * 
 */
package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tvt.model.bean.Account;
import com.tvt.model.bean.Branch;
import com.tvt.model.dao.AccountDAO;

/**
 * @author Quoc
 *
 */
public class AccountBO {
	AccountDAO accountDAO = new AccountDAO();

	public ArrayList<Account> getListAccount() throws SQLException {
		return accountDAO.getListAccount();
	}
}
