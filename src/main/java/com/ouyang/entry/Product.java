package com.ouyang.entry;

import java.util.Date;
import com.ouyang.common.annotation.Entry;

@Entry
public class Product
{
	private String spic;
	private Double price;
	private Double sell;
	private String name;
	private Date ctime;
	private Long id;
	private String sn;
	private String pic;
	private Integer sort;
	private Dir dir;
	private String content;

	public String getSpic()
	{
		return this.spic;
	}
	public void setSpic(String spic)
	{
		this.spic=spic;
	}
	public Double getPrice()
	{
		return this.price;
	}
	public void setPrice(Double price)
	{
		this.price=price;
	}
	public Double getSell()
	{
		return this.sell;
	}
	public void setSell(Double sell)
	{
		this.sell=sell;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public Date getCtime()
	{
		return this.ctime;
	}
	public void setCtime(Date ctime)
	{
		this.ctime=ctime;
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
	public String getPic()
	{
		return this.pic;
	}
	public void setPic(String pic)
	{
		this.pic=pic;
	}
	public Integer getSort()
	{
		return this.sort;
	}
	public void setSort(Integer sort)
	{
		this.sort=sort;
	}
	public Dir getDir()
	{
		return this.dir;
	}
	public void setDir(Dir dir)
	{
		this.dir=dir;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setContent(String content)
	{
		this.content=content;
	}

}