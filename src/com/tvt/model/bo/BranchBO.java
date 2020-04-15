/**
 * 
 */
package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tvt.model.bean.Branch;
import com.tvt.model.dao.BranchDAO;

/**
 * @author Quoc
 *
 */
public class BranchBO {
	BranchDAO branchDAO = new BranchDAO();

	public ArrayList<Branch> getListBranch() throws SQLException {
		return branchDAO.getListBranch();
	}
}
