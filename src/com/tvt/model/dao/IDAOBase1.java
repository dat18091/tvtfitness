/*
 *
 * Date: Apr 20, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAOBase1<T> {
	List<T> getAll();

	void insert(T object);

	void update(T object);

	void delete(String object);
}
