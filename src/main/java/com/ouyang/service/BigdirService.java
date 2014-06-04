package com.ouyang.service;

import java.util.List;

import com.ouyang.entry.Bigdir;

public interface BigdirService
{
	public boolean add(Bigdir bigdir);

	public boolean delete(Long id);

	public boolean update(Bigdir bigdir);

	public Bigdir getById(Long id);

	public List<Bigdir> list();
}