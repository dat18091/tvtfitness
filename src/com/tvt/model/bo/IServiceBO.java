package com.tvt.model.bo;

import java.util.List;

import com.tvt.model.bean.Service;

/**
 * @author dat18
 *
 */
public interface IServiceBO<T> {

	public List<Service> getAll();
	
	public void insert(T object);
	
	public void update(T object);
	
	public void delete(String object);
	
	public T searchById(String object) throws Exception;
}
