package com.tvt.model.dao;

import java.util.List;

/**
 * @author dat18
 *
 */
public interface IDAOBase<T> {
	
	List<T> getAll();
	
	void insert(T object);
	
	void update(T object);
	
	void delete(String object);
	
}
