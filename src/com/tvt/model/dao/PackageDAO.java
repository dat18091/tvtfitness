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
	/* (non-Javadoc)
	 * @see com.tvt.model.dao.IDAOBase#getAll()
	 */
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

	/* (non-Javadoc)
	 * @see com.tvt.model.dao.IDAOBase#insert(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see com.tvt.model.dao.IDAOBase#update(java.lang.Object)
	 */
	@Override
	public void update(Package package1) {
		String query = "UPDATE PACKAGE SET packageName = ?, packageType = ?, price = ? WHERE packageId = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, package1.getPackageName());
			preparedStatement.setString(2, package1.getPackageType());
			preparedStatement.setFloat(3, package1.getPrice());
			preparedStatement.setString(4, package1.getPackageId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.tvt.model.dao.IDAOBase#delete(java.lang.String)
	 */
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
	
	
	/**
	 * @param packageId
	 * @return
	 * @throws SQLException
	 * hiển thị thông tin lên form cập nhật
	 */
	public Package searchById(String packageId) throws SQLException {
		String query = "SELECT * FROM PACKAGE WHERE packageId = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, packageId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			String packageName = resultSet.getNString("packageName");
			String packageType = resultSet.getNString("packageType");
			float price = resultSet.getFloat("price");
			Package service = new Package(packageId, packageName, packageType, price);
			return service;
		}
		return null;
	}

}
