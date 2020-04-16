package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.List;

import com.tvt.model.bean.Account;
import com.tvt.model.dao.AccountDao;

public class AccountBO {
	private AccountDao accountDao= new AccountDao();
	public List<Account> getAccountList() throws SQLException{
		return accountDao.getAllAccount();
	}
	
	public boolean insertAccount(Account account) throws SQLException {
		return accountDao.insertAccount(account);
	}
	
	public boolean updateAccount(Account account) throws SQLException {
		return accountDao.updateAccount(account);
	}
	
	public boolean deleteAccount(String accountId) throws SQLException {
		return accountDao.delete(accountId);
	}

}
