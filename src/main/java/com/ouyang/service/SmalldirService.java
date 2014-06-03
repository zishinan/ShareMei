package com.ouyang.service;

import java.util.List;

import com.ouyang.entry.Smalldir;

public interface SmalldirService
{
	public boolean add(Smalldir smalldir);
	
	public boolean delete(Long id);
	
	public boolean update(Smalldir smalldir);
	
	public Smalldir getById(Long id);
	
	public List<Smalldir> list();
}
