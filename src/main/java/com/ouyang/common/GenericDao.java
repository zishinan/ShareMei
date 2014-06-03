package com.ouyang.common;

import java.util.List;


public interface GenericDao<T>
{
	public boolean add(T t);
	
	public boolean delete(Long id);
	
	public boolean update(T t);
	
	public T getById(Long id);
	
	public List<T> listQuery(String condition,Object[] params,Integer start,Integer max);
}
