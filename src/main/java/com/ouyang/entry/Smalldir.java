package com.ouyang.entry;

import com.ouyang.common.Entry;

@Entry
public class Smalldir
{
	private Long id;
	private String name;
	private String sn;
	private Bigdir bigdir;
	private Integer sort;
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSn()
	{
		return sn;
	}
	public void setSn(String sn)
	{
		this.sn = sn;
	}
	public Integer getSort()
	{
		return sort;
	}
	public void setSort(Integer sort)
	{
		this.sort = sort;
	}
	public Bigdir getBigdir()
	{
		return bigdir;
	}
	public void setBigdir(Bigdir bigdir)
	{
		this.bigdir = bigdir;
	}
	@Override
	public String toString()
	{
		return "Smalldir [id=" + id + ", name=" + name + ", sn=" + sn
				+ ", bigdir=" + bigdir + ", sort=" + sort + "]";
	}
	
}
