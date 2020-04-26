package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.List;

import com.tvt.model.bean.Account;
import com.tvt.model.dao.AccountDao;

public class AccountBO {
	private AccountDao accountDao= new AccountDao();
	
	public List<Account> getAllAccounts(){
		return accountDao.getAllAccount();
	}
	
	public List<Account> getAccounts(int start, int recordPerPage){
		return accountDao.getAccounts(start,recordPerPage);
	}
	
	public int numberOfRecord() {
		return accountDao.numberOfRecord();
	}
	
	public Account getAccount(int accountId) {
		return accountDao.getAccount(accountId);
	}
	public boolean insertAccount(Account account) throws SQLException {
		return accountDao.insertAccount(account);
	}
	
	public boolean updateAccount(Account account) throws SQLException {
		return accountDao.updateAccount(account);
	}
	
	public boolean deleteAccount(int accountId){
		return accountDao.delete(accountId);
	}
	
	public int startPosition(int currentPage, int recordPerPage) {
		return currentPage * recordPerPage - recordPerPage;
	}

	public int noOfPage(int rows, int recordPerPage) {
		int nOfPage = rows / recordPerPage;
		if (rows % recordPerPage > 0) {
			nOfPage++;
		}
		return nOfPage;
	}

	public int endPosition(int rows, int start, int recordPerPage) {
		int end = start + recordPerPage + 1;
		if (end > rows) {
			end = rows;
		}
		return end;
	}
	
	public Account getAccount(String userName, String password) {
		return accountDao.getAccount(userName, password);
	}
	
}
