package com.ouyang.dao.impl;

import java.util.List;

import com.ouyang.common.jdbc.GenericDaoImpl;
import com.ouyang.dao.DirDao;
import com.ouyang.entity.Dir;

public class DirDaoImpl extends GenericDaoImpl<Dir> implements DirDao
{
	@Override
	public List<Dir> listQuery(String condition, Object[] params,
			Integer start, Integer max)
	{
		List<Dir> list = super.listQuery(condition, params, start, max);
		for (Dir dir : list)
		{
			if(dir.getDir() == null)
			{
				Dir tempDir = new Dir();
				tempDir.setName("无");
				dir.setDir(tempDir);
			}
		}
		return list;
	}
	
	
	@Override
	public boolean nameExist(String name)
	{
		String condition = "name = ?";
		Object[] params = new Object[]{name};
		List<Dir> list = listQuery(condition, params, null, null);
		if(list != null && list.size() > 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean snExist(String sn)
	{
		String condition = "sn = ?";
		Object[] params = new Object[]{sn};
		List<Dir> list = listQuery(condition, params, null, null);
		if(list != null && list.size() > 0)
		{
			return true;
		}
		return false;
	}
}