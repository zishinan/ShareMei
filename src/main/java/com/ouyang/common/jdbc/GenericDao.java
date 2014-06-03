package com.ouyang.common.jdbc;

import java.util.List;


public interface GenericDao<T>
{
	public boolean add(T t);
	
	public boolean delete(Long id);
	
	public boolean update(T t);
	
	public T getById(Long id);
	
	/**
	 * @param condition 条件
	 * @param params 参数
	 * @param start 从哪条开始
	 * @param max 查询条数
	 * @return
	 */
	public List<T> listQuery(String condition,Object[] params,Integer start,Integer max);
	
	/**
	 * 执行isnert update delete语句
	 * @param sql 完整的sql语句
	 * @param params 参数
	 * @return
	 */
	public boolean update(String sql, Object... params);
	
	/**
	 * 完整的sql语句查询
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object query(String sql,Object[] params);
}
