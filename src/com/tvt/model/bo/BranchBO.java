package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.tvt.model.bean.Branch;
import com.tvt.model.dao.BranchDao;

public class BranchBO {

	private BranchDao branchDao = new BranchDao();

	public List<Branch> getBranchs(int start, int recordPerPage) {
		return branchDao.getBrandList(start, recordPerPage);
	}

	public boolean insertBrand(Branch branch) throws SQLException {
		return branchDao.insertBranch(branch);
	}

	public boolean updateBranch(Branch branch) throws SQLException {
		return branchDao.updateBranch(branch);
	}

	public boolean deleteBranch(String branchId) {
		return branchDao.deleteBranch(branchId);
	}

	public int numberOfRecord() {
		return branchDao.numberOfRecords();
	}

	public Branch getBranch(String id) {
		return branchDao.getBranch(id);
	}

	public List<Branch> getAllBranch() {
		return branchDao.getAllBranch();
	}

	public List<String> getBranchNames() {
		return getAllBranch().stream().map(x -> x.getBranchName()).collect(Collectors.toList());
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
		int end = start + recordPerPage;
		if (end > rows) {
			end = rows;
		}
		return end;
	}
}
