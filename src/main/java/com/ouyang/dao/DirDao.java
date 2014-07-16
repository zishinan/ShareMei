package com.ouyang.dao;

import com.ouyang.common.jdbc.GenericDao;
import com.ouyang.entity.Dir;

public interface DirDao extends GenericDao<Dir>
{
	public boolean nameExist(String name);
	
	public boolean snExist(String sn);
	
}