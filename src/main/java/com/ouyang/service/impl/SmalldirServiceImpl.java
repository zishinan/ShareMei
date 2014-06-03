package com.ouyang.service.impl;

import java.util.List;

import com.ouyang.dao.SmalldirDao;
import com.ouyang.dao.impl.SmalldirDaoImpl;
import com.ouyang.entry.Smalldir;
import com.ouyang.service.SmalldirService;

public class SmalldirServiceImpl implements SmalldirService
{
	private static SmalldirDao smalldirDao = new SmalldirDaoImpl();
	@Override
	public boolean add(Smalldir smalldir)
	{
		return smalldirDao.add(smalldir);
	}
	@Override
	public boolean delete(Long id)
	{
		return smalldirDao.delete(id);
	}
	@Override
	public boolean update(Smalldir smalldir)
	{
		return smalldirDao.update(smalldir);
	}
	@Override
	public Smalldir getById(Long id)
	{
		return smalldirDao.getById(id);
	}
	@Override
	public List<Smalldir> list()
	{
		return smalldirDao.listQuery(null, null, null, null);
	}
}
