package com.ouyang.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ouyang.common.BaseDao;
import com.ouyang.dao.BigdirDao;
import com.ouyang.entry.Bigdir;

public class BigdirDaoImpl extends BaseDao implements BigdirDao
{
	@Override
	public boolean add(Bigdir bigdir)
	{
		String sql = "insert into bigdir values(null,?,?,?)";
		Object[] params = {bigdir.getName(),bigdir.getSn(),bigdir.getSort()};
		
		return update(sql, params);
	}

	@Override
	public boolean delete(Long id)
	{
		String sql = "delete from bigdir where id = ?";
		return update(sql, id);
	}

	@Override
	public boolean update(Bigdir bigdir)
	{
		String sql = "update bigdir set name = ?,sn = ?,sort = ? where id = ?";
		Object[] params = {bigdir.getName(),bigdir.getSn(),bigdir.getSort(),bigdir.getId()};
		return update(sql, params);
	}

	@Override
	public Bigdir getById(Long id)
	{
		String sql = "select * from bigdir where id = ?";
		return query(sql, new BeanHandler<>(Bigdir.class), id);
	}

	@Override
	public List<Bigdir> listQuery(String condition)
	{
		List<Bigdir> list = new LinkedList<>();
		StringBuilder sql = new StringBuilder("select * from bigdir");
		if(condition != null)
		{
			sql.append(condition);
		}
		return query(sql.toString(), new BeanListHandler<>(Bigdir.class));
	}

	@Override
	public List<Bigdir> query(String condition)
	{
		return null;
	}
	
}
