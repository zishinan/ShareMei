package com.ouyang.dao;

import java.util.List;

import com.ouyang.entry.Bigdir;

public interface BigdirDao
{
	public boolean add(Bigdir bigdir);
	public boolean delete(Long id);
	public boolean update(Bigdir bigdir);
	public Bigdir getById(Long id);
	public List<Bigdir> listQuery(String condition);
	public List<Bigdir> query(String condition);
}
