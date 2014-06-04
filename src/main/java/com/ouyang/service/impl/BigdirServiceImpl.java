package com.ouyang.service.impl;

import java.util.List;
import com.ouyang.dao.BigdirDao;
import com.ouyang.dao.impl.BigdirDaoImpl;
import com.ouyang.entry.Bigdir;
import com.ouyang.service.BigdirService;

public class BigdirServiceImpl implements BigdirService
{
	private static BigdirDao bigdirDao = new BigdirDaoImpl();
	@Override
	public boolean add(Bigdir bigdir)
	{
		return bigdirDao.add(bigdir);
	}
	@Override
	public boolean delete(Long id)
	{
		return bigdirDao.delete(id);
	}
	@Override
	public boolean update(Bigdir bigdir)
	{
		return bigdirDao.update(bigdir);
	}
	@Override
	public Bigdir getById(Long id)
	{
		return bigdirDao.getById(id);
	}
	@Override
	public List<Bigdir> list()
	{
		return bigdirDao.listQuery(null, null, null, null);
	}
}