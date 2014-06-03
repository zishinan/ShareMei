package com.ouyang.entry;

import com.ouyang.common.annotation.Entry;

@Entry
public class Bigdir
{
	private String name;
	private Long id;
	private String sn;
	private Integer sort;

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
	public String getSn()
	{
		return this.sn;
	}
	public void setSn(String sn)
	{
		this.sn=sn;
	}
	public Integer getSort()
	{
		return this.sort;
	}
	public void setSort(Integer sort)
	{
		this.sort=sort;
	}

}