/**
 * 
 */
package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tvt.model.bean.Account;
import com.tvt.model.bean.Branch;

/**
 * @author Quoc
 *
 */
public class AccountDAO {
	public ArrayList<Account> getListAccount() throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT accountId, accountName, password, accountType, accountLevel FROM ACCOUNT";
		try {
			conn = com.tvt.common.ConnectDB.getConnect();
			pstm = conn.prepareStatement(sql);

			rs = pstm.executeQuery();

			ArrayList<Account> list = new ArrayList<Account>();
			while (rs.next()) {
				String accountId = rs.getString("accountId");
				String accountName = rs.getString("accountName");
				String password = rs.getString("password");
				String accountType = rs.getString("accountType");
				String accountLevel = rs.getString("accountLevel");

				Account account = new Account();
				account.setAccountId(accountId);
				account.setAccountName(accountName);
				account.setPassword(password);
				account.setAccountType(accountType);
				account.setAccountLevel(accountLevel);
				list.add(account);
			}
			return list;
		} finally {
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}
}
