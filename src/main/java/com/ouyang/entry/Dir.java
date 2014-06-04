package com.ouyang.entry;

import com.ouyang.common.annotation.Entry;

@Entry
public class Dir
{
	private Integer sequence;
	private String name;
	private Long id;
	private Dir dir;

	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer sequence)
	{
		this.sequence=sequence;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public Long getId()
	{
		return this.id;
	}
	public void setId(Long id)
	{
		this.id=id;
	}
	public Dir getDir()
	{
		return this.dir;
	}
	public void setDir(Dir dir)
	{
		this.dir=dir;
	}

}