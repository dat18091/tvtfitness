 	package com.tvt.model.bo;

import java.util.List;

/**
 * @author DAO
 *
 */
public interface IPackageBO<T> {
	public List<T> getAll();
	
	public void insert(T object);
	
	public void delete(String object);
	
	public void update(T object);
	
	public T searchById(String object) throws Exception;
}
