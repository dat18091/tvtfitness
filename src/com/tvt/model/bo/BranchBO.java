package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.List;

import com.tvt.model.bean.Branch;
import com.tvt.model.dao.BranchDao;

public class BranchBO {
	
	private BranchDao branchDao= new BranchDao();

	public List<Branch> getBranchs(int start,int recordPerPage) throws SQLException {
		return branchDao.getBrandList(start,recordPerPage);
	}

	public boolean insertBrand(Branch branch) throws SQLException {
		return branchDao.insertBranch(branch);
	}

	public boolean updateBranch(Branch branch) throws SQLException {
		return branchDao.updateBranch(branch);
	}
	
	public boolean deleteBranch(String branchId)throws SQLException{
		return branchDao.deleteBranch(branchId);
	}

	public int numberOfRecord() throws SQLException {
		return branchDao.numberOfRecords();
	}
	
	public Branch getBranch(String id) throws SQLException {
		return branchDao.getBranch(id);
	}

}
