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
}
