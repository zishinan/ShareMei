package com.ouyang.common.form;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseForm
{
	private Map<String, String> errors = new HashMap<>();
	public Map<String, String> getErrors()
	{
		return errors;
	}

	public boolean validate()
	{
		customValidate();
		
		return errors.isEmpty();
	}
	
	
	protected abstract void customValidate();

	protected void addError(String name,String error)
	{
		errors.put(name, "<span style = \"color:red\">" + error + "</span>");
	}
}
