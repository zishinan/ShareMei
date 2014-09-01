package com.ouyang.entity;

import com.ouyang.common.annotation.Entry;

@Entry
public class Product
{
	private Double costPrice;
	private String sn;
	private String pic;
	private String spic;
	private Integer storeNum;
	private String ctime;
	private Long id;
	private String content;
	private Double price;
	private Dir dir;
	private Integer sequence;
	private String name;
	private Integer clickNum;
	private Double salePrice;

	public Double getCostPrice()
	{
		return this.costPrice;
	}
	public void setCostPrice(Double costPrice)
	{
		this.costPrice=costPrice;
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
	public String getSpic()
	{
		return this.spic;
	}
	public void setSpic(String spic)
	{
		this.spic=spic;
	}
	public Integer getStoreNum()
	{
		return this.storeNum;
	}
	public void setStoreNum(Integer storeNum)
	{
		this.storeNum=storeNum;
	}
	public String getCtime()
	{
		return this.ctime;
	}
	public void setCtime(String ctime)
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
	public String getContent()
	{
		return this.content;
	}
	public void setContent(String content)
	{
		this.content=content;
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
	public Integer getClickNum()
	{
		return this.clickNum;
	}
	public void setClickNum(Integer clickNum)
	{
		this.clickNum=clickNum;
	}
	public Double getSalePrice()
	{
		return this.salePrice;
	}
	public void setSalePrice(Double salePrice)
	{
		this.salePrice=salePrice;
	}

}