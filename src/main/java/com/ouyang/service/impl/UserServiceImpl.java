package com.ouyang.service.impl;

import java.util.List;

import com.ouyang.dao.UserDao;
import com.ouyang.dao.impl.UserDaoImpl;
import com.ouyang.entity.User;
import com.ouyang.service.UserService;

public class UserServiceImpl implements UserService
{
	private static UserDao userDao = new UserDaoImpl();
	@Override
	public boolean add(User user)
	{
		user.setCtime(System.currentTimeMillis() + "");
		return userDao.add(user);
	}
	@Override
	public boolean delete(Long id)
	{
		return userDao.delete(id);
	}
	@Override
	public boolean update(User user)
	{
		return userDao.update(user);
	}
	@Override
	public User getById(Long id)
	{
		return userDao.getById(id);
	}
	@Override
	public List<User> list()
	{
		return userDao.listQuery(null, null, null, null);
	}
}