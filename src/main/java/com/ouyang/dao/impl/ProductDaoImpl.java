package com.ouyang.dao.impl;

import java.util.Date;
import java.util.List;

import com.ouyang.common.jdbc.GenericDaoImpl;
import com.ouyang.dao.ProductDao;
import com.ouyang.entity.Product;
import com.ouyang.util.DateUtil;

public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao
{
	@Override
	public List<Product> listQuery(String condition, Object[] params, Integer start, Integer max)
	{
		List<Product> list = super.listQuery(condition, params, start, max);
		for (Product product : list)
		{
			Date ctime = product.getCtime();
			if(ctime != null)
			{
				// TODO 时间格式处理
//				product.setCtime(DateUtil.formatDate(ctime));
			}
		}
		return list;
	}
}