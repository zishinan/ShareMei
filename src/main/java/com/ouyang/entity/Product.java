package com.ouyang.entity;

import java.util.Date;
import com.ouyang.common.annotation.Entry;

@Entry
public class Product
{
	private String content;
	private Long id;
	private String sn;
	private Double costPrice;
	private Double price;
	private Dir dir;
	private Integer sequence;
	private String name;
	private Double salePrice;
	private Integer storeNum;
	private String spic;
	private String pic;
	private Date ctime;

	public String getContent()
	{
		return this.content;
	}
	public void setContent(String content)
	{
		this.content=content;
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
	public Double getCostPrice()
	{
		return this.costPrice;
	}
	public void setCostPrice(Double costPrice)
	{
		this.costPrice=costPrice;
	}
	public Double getPrice()
	{
		return this.price;
	}
	public void setPrice(Double price)
	{
		this.price=price;
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
	public Double getSalePrice()
	{
		return this.salePrice;
	}
	public void setSalePrice(Double salePrice)
	{
		this.salePrice=salePrice;
	}
	public Integer getStoreNum()
	{
		return this.storeNum;
	}
	public void setStoreNum(Integer storeNum)
	{
		this.storeNum=storeNum;
	}
	public String getSpic()
	{
		return this.spic;
	}
	public void setSpic(String spic)
	{
		this.spic=spic;
	}
	public String getPic()
	{
		return this.pic;
	}
	public void setPic(String pic)
	{
		this.pic=pic;
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