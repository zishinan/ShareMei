package com.ouyang.service;

import java.util.List;

import com.ouyang.common.exception.LogicException;
import com.ouyang.entity.Dir;

public interface DirService
{
	public boolean add(Dir dir) throws LogicException;

	public boolean delete(Long id);

	public boolean update(Dir dir);

	public Dir getById(Long id);

	public List<Dir> list();
}