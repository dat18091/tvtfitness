package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.List;

import com.tvt.model.bean.Service;
import com.tvt.model.dao.ServiceDAO;

/**
 * @author dat18
 *
 */
public class ServiceBOImpl implements IServiceBO<Service> {
	ServiceDAO serviceDAO = new ServiceDAO();
	
	@Override
	public List<Service> getAll() {
		return serviceDAO.getAll();
	}

	@Override
	public void insert(Service service) {
		serviceDAO.insert(service);
	}

	@Override
	public void delete(String serviceId) {
		serviceDAO.delete(serviceId);
	}

	@Override
	public Service searchById(String serviceId) throws SQLException {
		return serviceDAO.searchById(serviceId);
	}

	@Override
	public void update(Service service) {
		serviceDAO.update(service);
	}
}
