package com.ouyang.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ouyang.dao.BigdirDao;
import com.ouyang.dao.SmalldirDao;
import com.ouyang.dao.SmalldirDao;
import com.ouyang.dao.impl.BigdirDaoImpl;
import com.ouyang.dao.impl.SmalldirDaoImpl;
import com.ouyang.dao.impl.SmalldirDaoImpl;
import com.ouyang.entry.Bigdir;
import com.ouyang.entry.Smalldir;
import com.ouyang.entry.Smalldir;


public class SmalldirTest
{
	@Test
	public void testConnection() throws Exception
	{
		SmalldirDao smalldirDao = new SmalldirDaoImpl();
		BigdirDao bigdirDao = new BigdirDaoImpl();
		Smalldir smalldir = new Smalldir();
		
		smalldir.setName("ouyangxi");
		smalldir.setSn("oyxx");
		smalldir.setSort(1);
		Bigdir bigdir = bigdirDao.getById(13L);
		smalldir.setBigdir(bigdir);
		System.out.println(smalldirDao.add(smalldir));
		
		
	}
	
	@Test
	public void testDelete() throws Exception
	{
		SmalldirDao smallDirDao = new SmalldirDaoImpl();
		System.out.println(smallDirDao.delete(1L));
	}
	
	@Test
	public void testUpdate() throws Exception
	{
		SmalldirDao smallDirDao = new SmalldirDaoImpl();
		BigdirDao bigdirDao = new BigdirDaoImpl();
		Smalldir smallDir = new Smalldir();
		Bigdir bigdir = bigdirDao.getById(13L);
		
		smallDir.setId(2L);
		smallDir.setBigdir(bigdir);
		smallDir.setName("ouyangdddd");
		smallDir.setSn("oyxxx");
		smallDir.setSort(23);
		System.out.println(smallDirDao.update(smallDir));
	}
	
	@Test
	public void testGet() throws Exception
	{
		SmalldirDao smalldirDao = new SmalldirDaoImpl();
		Smalldir smalldir = smalldirDao.getById(4L);
		System.out.println(smalldir.toString());
	}
	
	@Test
	public void testList() throws Exception
	{
		SmalldirDao bigdirDao = new SmalldirDaoImpl();
		List<Smalldir> list = bigdirDao.listQuery(null,null,null,null);
		
		for (Smalldir bigdir : list)
		{
			System.out.println(bigdir.toString());
		}
	}
}
