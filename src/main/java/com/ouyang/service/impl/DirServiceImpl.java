package com.ouyang.service.impl;

import java.util.List;

import com.ouyang.common.exception.LogicException;
import com.ouyang.dao.DirDao;
import com.ouyang.dao.impl.DirDaoImpl;
import com.ouyang.entity.Dir;
import com.ouyang.service.DirService;

public class DirServiceImpl implements DirService
{
	private static DirDao dirDao = new DirDaoImpl();
	@Override
	public boolean add(Dir dir) throws LogicException
	{
		dir.setSequence(1);
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
		dir.setSequence(1);
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