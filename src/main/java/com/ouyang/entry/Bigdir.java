package com.ouyang.entry;

public class Bigdir
{
	private Long id;
	private String name;
	private String sn;
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
	@Override
	public String toString()
	{
		return "Bigdir [id=" + id + ", name=" + name + ", sn=" + sn + ", sort="
				+ sort + "]";
	}
}
