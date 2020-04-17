package com.tvt.model.bo;

import java.util.List;

/**
 * @author dat18
 *
 */
public interface IServiceBO<T> {
	public List<T> getAll();
	
	public void insert(T object);
	
	public void delete(String object);
	
	public T searchById(String object) throws Exception;
	
	public void update(T object);
}
