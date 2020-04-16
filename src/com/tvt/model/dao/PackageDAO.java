package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tvt.model.bean.Package;
import com.tvt.common.ConnectDB;

/**
 * @author DAO
 *
 */
public class PackageDAO implements IDAOBase<Package>{
	private Connection con = ConnectDB.getConnect();
	@Override
	public List<Package> getAll() {
		List<Package> packagesList = new ArrayList<Package>();
		String query = "SELECT * FROM PACKAGE";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Package package1 = new Package();
				package1.setPackageId(resultSet.getString("packageId"));
				package1.setPackageName(resultSet.getNString("packageName"));
				package1.setPackageType(resultSet.getNString("packageType"));
				package1.setPrice(resultSet.getFloat("price"));
				packagesList.add(package1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return packagesList;
	}

	@Override
	public void insert(Package object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Package object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String object) {
		// TODO Auto-generated method stub
		
	}

}
