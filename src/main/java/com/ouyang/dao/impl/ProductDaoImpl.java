package com.ouyang.dao.impl;

import java.util.List;

import com.ouyang.common.jdbc.GenericDaoImpl;
import com.ouyang.dao.ProductDao;
import com.ouyang.entity.Product;

public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao
{
	@Override
	public boolean nameExist(String name)
	{
		String condition = "name = ?";
		Object[] params = new Object[]{name};
		List<Product> list = listQuery(condition, params, null, null);
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
		List<Product> list = listQuery(condition, params, null, null);
		if(list != null && list.size() > 0)
		{
			return true;
		}
		return false;
	}
}