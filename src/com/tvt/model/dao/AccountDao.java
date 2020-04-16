package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tvt.common.ConnectDB;
import com.tvt.model.bean.Account;

/**
 * 
 * @author HienTT20
 *
 */
public class AccountDao{
	private Connection conn;

	public List<Account> getAllAccount() throws SQLException{
		conn = ConnectDB.getConnect();
		List<Account> accounts = new ArrayList<Account>();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("select * from ACCOUNT");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getString("accountId"));
				account.setAccountName(rs.getString("accountName"));
				account.setPassword(rs.getString("password"));
				account.setAccountType(rs.getNString("accountType"));
				account.setAccountLevel(rs.getNString("accountLevel"));
				accounts.add(account);
			}
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	public boolean insertAccount(Account account) throws SQLException{
		conn = ConnectDB.getConnect();
		String insertQuery = "insert into ACCOUNT(accountId,accountName,password,accountType,accountLevel) values(?,?,?,?,?)";
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement(insertQuery);
			pst.setString(1, account.getAccountId());
			pst.setString(2, account.getAccountName());
			pst.setString(3, account.getPassword());
			pst.setString(4, account.getAccountType());
			pst.setNString(5, account.getAccountLevel());
			row = pst.executeUpdate();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(row >0) {
			return true;
		}
		return false;
	}

	public boolean updateAccount(Account account) throws SQLException{
		conn = ConnectDB.getConnect();
		String updateQuery = "update ACCOUNT set accountName = ?, password = ?, accountType = ?,accountLevel = ? where accountId = ?";
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement(updateQuery);

			pst.setString(1, account.getAccountName());
			pst.setString(2, account.getPassword());
			pst.setString(3, account.getAccountType());
			pst.setNString(4, account.getAccountLevel());
			pst.setString(5, account.getAccountId());
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(row>0) {
			return true;
		}
		return false;

	}


	public boolean delete(String account) throws SQLException{
		conn = ConnectDB.getConnect();
		String deleteQuery = "delete from ACCOUNT where accountId = ?";
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement(deleteQuery);
			pst.setString(1, account);
			row = pst.executeUpdate();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(row>0) {
			return true;
		}
		return false;

	}

}
