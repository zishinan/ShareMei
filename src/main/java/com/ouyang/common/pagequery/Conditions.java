package com.ouyang.common.pagequery;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class Conditions
{
	private String condition;
	private Object[] params;
	
	public Conditions add(String condition,Object param)
	{
		if(StringUtils.isBlank(this.condition))
		{
			this.condition = condition + " = ?";
			this.params = new Object[]{param};
		}
		else 
		{
			this.condition = this.condition + " and " + condition + " = ?";
			this.params = ArrayUtils.add(this.params, param);
		}
		return this;
	}
	
	public String getCondition()
	{
		return condition;
	}
	public void setCondition(String condition)
	{
		this.condition = condition;
	}
	public Object[] getParams()
	{
		return params;
	}
	public void setParams(Object[] params)
	{
		this.params = params;
	}
}
