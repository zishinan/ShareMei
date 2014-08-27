package com.ouyang.form.query;

import org.apache.commons.lang3.StringUtils;

import com.ouyang.common.pagequery.Conditions;

public class BaseQueryForm
{
	private String name;
	private String sn;
	private String dir_id;
	private String content;
	
	public Conditions getConditions()
	{
		Conditions conditions = new Conditions();
		if (StringUtils.isNotBlank(name))
		{
			conditions.add("name", name);
		}
		
		if(StringUtils.isNotBlank(sn))
		{
			conditions.add("sn", sn);
		}
		
		if(StringUtils.isNotBlank(dir_id))
		{
			conditions.add("dir_id",dir_id);
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
