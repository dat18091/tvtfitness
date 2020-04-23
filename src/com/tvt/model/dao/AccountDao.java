package com.tvt.model.dao;

import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tvt.common.ConnectDB;
import com.tvt.model.bean.Account;

/**
 * 
 * @author HienTT20
 *
 */
public class AccountDao {
	private Connection conn;

	public List<Account> getAllAccount() {
		conn = ConnectDB.getConnect();
		List<Account> accounts = new ArrayList<Account>();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("select * from ACCOUNT");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getInt("accountId"));
				account.setAccountName(rs.getString("accountName"));
				account.setPassword(rs.getString("password"));
				account.setAccountType(rs.getString("accountType"));
				accounts.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		return accounts;
	}

	public boolean insertAccount(Account account) throws SQLException {
		conn = ConnectDB.getConnect();
		String insertQuery = "insert into ACCOUNT(accountName,password,accountType) values(?,?,?)";
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement(insertQuery);
			pst.setString(1, account.getAccountName());
			pst.setString(2, account.getPassword());
			pst.setString(3, account.getAccountType());
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
		if (row > 0) {
			return true;
		}
		return false;
	}

	public boolean updateAccount(Account account) throws SQLException {
		conn = ConnectDB.getConnect();
		String updateQuery = "update ACCOUNT set accountName = ?, password = ?, accountType = ? where accountId = ?";
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement(updateQuery);

			pst.setString(1, account.getAccountName());
			pst.setString(2, account.getPassword());
			pst.setString(3, account.getAccountType());
			pst.setInt(4, account.getAccountId());
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
		if (row > 0) {
			return true;
		}
		return false;

	}

	public boolean delete(int account) {
		conn = ConnectDB.getConnect();
		String deleteQuery = "delete from ACCOUNT where accountId = ?";
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement(deleteQuery);
			pst.setInt(1, account);
			row = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		if (row > 0) {
			return true;
		}
		return false;

	}

	public List<Account> getAccounts(int start, int recordPerPage) {
		conn = ConnectDB.getConnect();
		List<Account> accounts = new ArrayList<Account>();
		PreparedStatement pst = null;
		try {
			pst = conn
					.prepareStatement("select * from ACCOUNT order by accountId offset ? rows fetch next ? rows only");
			pst.setInt(1, start);
			pst.setInt(2, recordPerPage);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getInt("accountId"));
				account.setAccountName(rs.getString("accountName"));
				account.setPassword(rs.getString("password"));
				account.setAccountType(rs.getString("accountType"));
				accounts.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		return accounts;
	}

	public int numberOfRecord() {
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement("select count(*) from ACCOUNT");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return row;
	}

	public Account getAccount(int accountId) {
		conn = ConnectDB.getConnect();
		Account account= new Account();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("select * from ACCOUNT where accountId= ?");
			pst.setInt(1, accountId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {	
				account.setAccountId(rs.getInt("accountId"));
				account.setAccountName(rs.getString("accountName"));
				account.setPassword(rs.getString("password"));
				account.setAccountType(rs.getString("accountType"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return account;

	}
	
	public Account getAccount(String userName, String password) {
		conn = ConnectDB.getConnect();
		Account account= new Account();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("select * from ACCOUNT where accountName= ? AND password = ?");
			pst.setString(1, userName);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {	
				account.setAccountId(rs.getInt("accountId"));
				account.setAccountName(rs.getString("accountName"));
				account.setPassword(rs.getString("password"));
				account.setAccountType(rs.getString("accountType"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return account;

	}
	

}
