package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tvt.common.ConnectDB;
import com.tvt.model.bean.Service;

/**
 * @author dat18
 *
 */
public class ServiceDAO implements IDAOBase1<Service> {
	private Connection con = ConnectDB.getConnect();

	@Override
	public List<Service> getAll() {
		List<Service> serviceList = new ArrayList<Service>();
		String query = "SELECT * FROM SERVICE";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Service service = new Service();
				service.setServiceId(resultSet.getString("serviceId"));
				service.setServiceName(resultSet.getNString("serviceName"));
				service.setServiceType(resultSet.getNString("serviceType"));
				service.setImageUrl(resultSet.getString("imgUrl"));
				service.setPrice(resultSet.getFloat("price"));
				serviceList.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serviceList;
	}

	@Override
	public void insert(Service service) {
		String query = "INSERT INTO SERVICE(serviceId, serviceName, serviceType, imgUrl, price) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, service.getServiceId());
			preparedStatement.setNString(2, service.getServiceName());
			preparedStatement.setNString(3, service.getServiceType());
			preparedStatement.setString(4, service.getImageUrl());
			preparedStatement.setFloat(5, service.getPrice());
			preparedStatement.executeUpdate();
//			if(result == 0) {
//				
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Service service) {
		String query = "update SERVICE set serviceName = ?, serviceType = ?, imgUrl = ?, price = ? where serviceId = ?";
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setNString(1, service.getServiceName());
			preparedStatement.setNString(2, service.getServiceType());
			preparedStatement.setString(3, service.getImageUrl());
			preparedStatement.setFloat(4, service.getPrice());
			preparedStatement.setString(5, service.getServiceId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String serviceId) {
		String query = "DELETE FROM SERVICE WHERE serviceId = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, serviceId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Service searchById(String serviceId) throws SQLException {
		String query = "SELECT * FROM SERVICE WHERE serviceId = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, serviceId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			String serviceName = resultSet.getNString("serviceName");
			String serviceType = resultSet.getNString("serviceType");
			String imageUrl = resultSet.getString("imgUrl");
			float price = resultSet.getFloat("price");
			Service service = new Service(serviceId, serviceName, serviceType, imageUrl, price);
			return service;
		}
		return null;
	}
}
