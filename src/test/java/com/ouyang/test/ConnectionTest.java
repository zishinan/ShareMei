package com.ouyang.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ouyang.dao.BigdirDao;
import com.ouyang.dao.impl.BigdirDaoImpl;
import com.ouyang.entry.Bigdir;


public class ConnectionTest
{
	@Test
	public void testConnection() throws Exception
	{
		BigdirDao bigdirDao = new BigdirDaoImpl();
		Bigdir bigdir = new Bigdir();
		
		bigdir.setName("ouyang");
		bigdir.setSn("oy");
		System.out.println(bigdirDao.add(bigdir));
		
		
	}
	
	@Test
	public void testDelete() throws Exception
	{
		BigdirDao bigdirDao = new BigdirDaoImpl();
		System.out.println(bigdirDao.delete(16L));
	}
	
	@Test
	public void testUpdate() throws Exception
	{
		BigdirDao bigdirDao = new BigdirDaoImpl();
		Bigdir bigdir = new Bigdir();
		
		bigdir.setId(15L);
		bigdir.setName("ouyang");
		bigdir.setSn("oy");
		bigdir.setSort(2);
		System.out.println(bigdirDao.update(bigdir));
	}
	
	@Test
	public void testGet() throws Exception
	{
		BigdirDao bigdirDao = new BigdirDaoImpl();
		Bigdir bigdir = bigdirDao.getById(15L);
		System.out.println(bigdir.toString());
	}
	
	@Test
	public void testList() throws Exception
	{
		BigdirDao bigdirDao = new BigdirDaoImpl();
		List<Bigdir> list = bigdirDao.listQuery(null);
		
		for (Bigdir bigdir : list)
		{
			System.out.println(bigdir.toString());
		}
	}
}
