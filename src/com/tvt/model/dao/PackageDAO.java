package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tvt.model.bean.Package;
import com.tvt.common.ConnectDB;

<<<<<<< HEAD
public class PackageDAO implements IDAOBase1<Package>{
	private Connection con = ConnectDB.getConnect();
=======
/**
 * @author DAO
 *
 */
public class PackageDAO implements IDAOBase<Package>{
	private Connection con = ConnectDB.getConnect();
	
	/**
	 * 
	 */
>>>>>>> e1f4e5e214f7c951f38c4f579503a77c45128370
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

<<<<<<< HEAD
=======
	/**
	 * 
	 */
>>>>>>> e1f4e5e214f7c951f38c4f579503a77c45128370
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

<<<<<<< HEAD
=======
	/**
	 * 
	 */
>>>>>>> e1f4e5e214f7c951f38c4f579503a77c45128370
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

<<<<<<< HEAD
=======
	/**
	 * 
	 */
>>>>>>> e1f4e5e214f7c951f38c4f579503a77c45128370
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
<<<<<<< HEAD
	public Package searchById(String packageId) throws SQLException {
=======
	public Package getAllById(String packageId) throws SQLException {
>>>>>>> e1f4e5e214f7c951f38c4f579503a77c45128370
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
