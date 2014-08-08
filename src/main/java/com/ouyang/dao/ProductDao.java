package com.ouyang.dao;

import com.ouyang.common.jdbc.GenericDao;
import com.ouyang.entity.Product;

public interface ProductDao extends GenericDao<Product>
{
	public boolean nameExist(String name);
	
	public boolean snExist(String sn);
}