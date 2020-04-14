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
public class ServiceDAO implements IDAOBase<Service> {
	private Connection con = ConnectDB.getConnect();
	
	@Override
	public List<Service> getAll() {
		List<Service> serviceList = new ArrayList<Service>();
		String query = "SELECT * FROM SERVICE";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Service service = new Service();
				service.setServiceId(resultSet.getString("serviceId"));
				service.setServiceName(resultSet.getNString("serviceName"));
				service.setServiceType(resultSet.getNString("serviceType"));
				service.setImageUrl(resultSet.getNString("imageUrl"));
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
		
	}

	@Override
	public void update(Service service) {
		
	}

	@Override
	public void delete(String serviceId) {
		
	}

}
