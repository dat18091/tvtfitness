package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tvt.common.ConnectDB;
import com.tvt.model.bean.Branch;

public class BranchDao {
	private Connection conn;

	public List<Branch> getBrandList(int start, int recordPerPage){
		List<Branch> branchs = new ArrayList<Branch>();
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("select * from BRANCH order by branchId offset ? rows fetch next ? rows only");
			pst.setInt(1, start);
			pst.setInt(2, recordPerPage);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Branch branch = new Branch();
				branch.setBranchId(rs.getString("branchId"));
				branch.setBranchName(rs.getNString("branchName"));
				branch.setAddress(rs.getNString("address"));
				branchs.add(branch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}
		return branchs;
	}

	public boolean insertBranch(Branch branch) throws SQLException {
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement("insert into BRANCH(branchId, branchName, address) values(?,?,?)");
			pst.setString(1, branch.getBranchId());
			pst.setNString(2, branch.getBranchName());
			pst.setNString(3, branch.getAddress());
			row = pst.executeUpdate();
		} finally {
			pst.close();
			conn.close();
		}
		if (row > 0) {
			return true;
		}
		return false;
	}

	public boolean updateBranch(Branch branch) throws SQLException {
		PreparedStatement pst = null;
		conn = ConnectDB.getConnect();
		int row = 0;
		try {
			pst = conn.prepareStatement("update BRANCH set branchName = ?, address = ? where branchId = ?");

			pst.setNString(1, branch.getBranchName());
			pst.setNString(2, branch.getAddress());
			pst.setString(3, branch.getBranchId());
			row = pst.executeUpdate();

		} finally {
			pst.close();
			conn.close();
		}
		if (row > 0) {
			return true;
		}
		return false;
	}

	public boolean deleteBranch(String branchId){
		PreparedStatement pst = null;
		conn = ConnectDB.getConnect();
		int row = 0;
		try {
			pst = conn.prepareStatement("delete from BRANCH where branchId = ?");
			pst.setString(1, branchId);
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

	public int numberOfRecords(){
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement("select count(*) from BRANCH");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
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

	public Branch getBranch(String id){
		PreparedStatement pst = null;
		conn = ConnectDB.getConnect();
		Branch branch = new Branch();
		try {
			pst = conn.prepareStatement("select * from BRANCH where branchId= ?");
			pst.setString(1, id);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				branch.setBranchId(rs.getString("branchId"));
				branch.setBranchName(rs.getNString("branchName"));
				branch.setAddress(rs.getNString("address"));
				
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
		return branch;
		
	}
	public List<Branch> getAllBranch(){
		List<Branch> branchs = new ArrayList<Branch>();
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("select * from BRANCH");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Branch branch = new Branch();
				branch.setBranchId(rs.getString("branchId"));
				branch.setBranchName(rs.getNString("branchName"));
				branch.setAddress(rs.getNString("address"));
				branchs.add(branch);
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
		return branchs;
	}

}
