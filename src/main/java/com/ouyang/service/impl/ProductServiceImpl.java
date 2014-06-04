package com.ouyang.service.impl;

import java.util.List;
import com.ouyang.dao.ProductDao;
import com.ouyang.dao.impl.ProductDaoImpl;
import com.ouyang.entry.Product;
import com.ouyang.service.ProductService;

public class ProductServiceImpl implements ProductService
{
	private static ProductDao productDao = new ProductDaoImpl();
	@Override
	public boolean add(Product product)
	{
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