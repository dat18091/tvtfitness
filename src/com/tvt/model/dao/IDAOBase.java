package com.tvt.model.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author dat18
 *
 */
public interface IDAOBase<T> {
	
	List<T> getAll(int start, int total, String search, String sortBy) throws SQLException;
	
	void insert(T object) throws SQLException;
	
	void update(T object) throws SQLException;
	
	void delete(String object) throws SQLException;
	
	T find(String object) throws SQLException;
}
