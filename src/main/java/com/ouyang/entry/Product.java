package com.ouyang.entry;

import java.util.Date;
import com.ouyang.common.annotation.Entry;

@Entry
public class Product
{
	private Long id;
	private String content;
	private String sn;
	private Double price;
	private Double sell;
	private Dir dir;
	private Integer sequence;
	private String name;
	private String pic;
	private String spic;
	private Date ctime;

	public Long getId()
	{
		return this.id;
	}
	public void setId(Long id)
	{
		this.id=id;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setContent(String content)
	{
		this.content=content;
	}
	public String getSn()
	{
		return this.sn;
	}
	public void setSn(String sn)
	{
		this.sn=sn;
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
	public Dir getDir()
	{
		return this.dir;
	}
	public void setDir(Dir dir)
	{
		this.dir=dir;
	}
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
	public String getPic()
	{
		return this.pic;
	}
	public void setPic(String pic)
	{
		this.pic=pic;
	}
	public String getSpic()
	{
		return this.spic;
	}
	public void setSpic(String spic)
	{
		this.spic=spic;
	}
	public Date getCtime()
	{
		return this.ctime;
	}
	public void setCtime(Date ctime)
	{
		this.ctime=ctime;
	}

}