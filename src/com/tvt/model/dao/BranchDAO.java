/**
 * 
 */
package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tvt.model.bean.Branch;
/**
 * @author Quoc
 *
 */
public class BranchDAO {
	public ArrayList<Branch> getListBranch() throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT branchId, branchName, address FROM BRANCH";
		try {
			conn = com.tvt.common.ConnectDB.getConnect();
			pstm = conn.prepareStatement(sql);

			rs = pstm.executeQuery();

			ArrayList<Branch> list = new ArrayList<Branch>();
			while (rs.next()) {
				String branchId = rs.getString("branchId");
				String branchName = rs.getString("branchName");
				String address = rs.getString("address");

				Branch branch = new Branch();
				branch.setBranchId(branchId);
				branch.setBranchName(branchName);
				branch.setAddress(address);
				list.add(branch);
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
