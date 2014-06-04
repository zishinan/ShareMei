package com.ouyang.service;

import java.util.List;

import com.ouyang.entry.Product;

public interface ProductService
{
	public boolean add(Product product);

	public boolean delete(Long id);

	public boolean update(Product product);

	public Product getById(Long id);

	public List<Product> list();
}