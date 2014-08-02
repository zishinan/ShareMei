package com.ouyang.service.impl;

import java.util.Date;
import java.util.List;

import com.ouyang.common.exception.LogicException;
import com.ouyang.dao.ProductDao;
import com.ouyang.dao.impl.ProductDaoImpl;
import com.ouyang.entity.Product;
import com.ouyang.service.ProductService;

public class ProductServiceImpl implements ProductService
{
	private static ProductDao productDao = new ProductDaoImpl();

	@Override
	public boolean add(Product product) throws LogicException
	{
		product.setClickNum(0);
		product.setCtime(new Date());
		product.setSequence(0);
		return productDao.add(product);
	}

	@Override
	public boolean delete(Long id)
	{
		return productDao.delete(id);
	}

	@Override
	public boolean update(Product product)
	{
		return productDao.update(product);
	}

	@Override
	public Product getById(Long id)
	{
		return productDao.getById(id);
	}

	@Override
	public List<Product> list()
	{
		return productDao.listQuery(null, null, null, null);
	}
}