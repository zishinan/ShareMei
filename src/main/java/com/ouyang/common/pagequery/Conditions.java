package com.ouyang.common.pagequery;

public class Conditions
{
	private String condition;
	private Object[] params;
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
