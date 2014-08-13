package com.ouyang.form;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.ouyang.common.form.BaseForm;
import com.ouyang.dao.ProductDao;
import com.ouyang.dao.impl.ProductDaoImpl;

/**
 * @author zishinan
 *
 */
public class ProductForm extends BaseForm
{
	private String name;
	private String sn;
	private String price;
	private String salePrice;
	private String costPrice;
	private String storeNum;
	private String id;
	private String content;
	
	public void customValidate()
	{
		ProductDao productDao = new ProductDaoImpl();
		
		if (StringUtils.isBlank(name))
		{
			addError("name", "产品名称不能为空！");
		}

		if (StringUtils.isBlank(sn))
		{
			addError("sn", "产品编号不能为空！");
		}
		else if (StringUtils.isBlank(id) && productDao.snExist(sn))
		{
			addError("sn", "产品编号已存在！");
		}
		if(NumberUtils.toInt(storeNum) == 0)
		{
			addError("storeNum", "库存输入不正确！");
		}
		
		if(NumberUtils.toDouble(price) == 0.0d)
		{
			addError("price", "原价输入不正确！");
		}
		
		if(NumberUtils.toDouble(salePrice) == 0.0d)
		{
			addError("salePrice", "折扣价输入不正确！");
		}
		
		if(NumberUtils.toDouble(costPrice) == 0.0d)
		{
			addError("costPrice", "进价输入不正确！");
		}
		
		if(StringUtils.isBlank(content))
		{
			addError("content", "简介不能为空！");
		}
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

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getSalePrice()
	{
		return salePrice;
	}

	public void setSalePrice(String salePrice)
	{
		this.salePrice = salePrice;
	}

	public String getCostPrice()
	{
		return costPrice;
	}

	public void setCostPrice(String costPrice)
	{
		this.costPrice = costPrice;
	}

	public String getStoreNum()
	{
		return storeNum;
	}

	public void setStoreNum(String storeNum)
	{
		this.storeNum = storeNum;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}
