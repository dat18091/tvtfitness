/*
 *
 * Date: Apr 15, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.bo;

import java.util.List;

public interface IBOBase<T> {

	List<T> getAll();

	void insert(T object);

	void update(T object);

	void delete(String object);

	T find(String object);
}
