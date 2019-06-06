package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.Pageble;

public interface GenericJDBC<T> {
	 List<T> query(String sql,  Object...parameters);
	 void update(String sql, Object... parameters);
	 Long insert(String sql, Object... parameters);
	 Long insert(Object object);
	 void update(Object object);
	//void delete(Object object);
	// public List<T> findById(Object object);
	 void delete(long id);
	  <T> T findById(long id);
	 List<T> search(Object object);
	 List<T> findAll(Map<String, Object> properties,Pageble pageble,Object...where);
}
