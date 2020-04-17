package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tvt.model.bean.Package;
import com.tvt.common.ConnectDB;

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
	public void insert(Package package1) {
		String query = "INSERT INTO PACKAGE(packageId, packageName, packageType, price) VALUES (?, ? , ?, ?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, package1.getPackageId());
			preparedStatement.setString(2, package1.getPackageName());
			preparedStatement.setString(3, package1.getPackageType());
			preparedStatement.setFloat(4, package1.getPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Package object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String packageId) {
		String query = "DELETE FROM PACKAGE WHERE packageId = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, packageId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
