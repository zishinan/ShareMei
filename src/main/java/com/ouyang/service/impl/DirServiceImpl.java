package com.ouyang.service.impl;

import java.util.List;
import com.ouyang.dao.DirDao;
import com.ouyang.dao.impl.DirDaoImpl;
import com.ouyang.entry.Dir;
import com.ouyang.service.DirService;

public class DirServiceImpl implements DirService
{
	private static DirDao dirDao = new DirDaoImpl();
	@Override
	public boolean add(Dir dir)
	{
		return dirDao.add(dir);
	}
	@Override
	public boolean delete(Long id)
	{
		return dirDao.delete(id);
	}
	@Override
	public boolean update(Dir dir)
	{
		return dirDao.update(dir);
	}
	@Override
	public Dir getById(Long id)
	{
		return dirDao.getById(id);
	}
	@Override
	public List<Dir> list()
	{
		return dirDao.listQuery(null, null, null, null);
	}
}