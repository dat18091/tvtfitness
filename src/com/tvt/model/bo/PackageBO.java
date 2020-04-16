package com.tvt.model.bo;

import java.util.List;

import com.tvt.model.dao.PackageDAO;
import com.tvt.model.bean.Package;

/**
 * @author DAO
 *
 */
public class PackageBO implements IPackageBO<Package>{
	PackageDAO packageDAO = new PackageDAO();

	@Override
	public List<Package> getAll() {
		// TODO Auto-generated method stub
		return packageDAO.getAll();
	}
}
