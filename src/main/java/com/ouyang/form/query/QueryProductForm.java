package com.ouyang.form.query;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ouyang.common.pagequery.Conditions;

public class QueryProductForm
{
	private String name;
	private String sn;
	private String dir_id;
	private String content;
	
	public Conditions getConditions()
	{
		Conditions conditions = new Conditions();
		StringBuilder condition = new StringBuilder();
		List<Object> params = new ArrayList<>();
		if (StringUtils.isNotBlank(name))
		{
			condition.append(" name = ?");
			params.add(name);
		}

		return conditions;
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
	public String getDir_id()
	{
		return dir_id;
	}
	public void setDir_id(String dir_id)
	{
		this.dir_id = dir_id;
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
