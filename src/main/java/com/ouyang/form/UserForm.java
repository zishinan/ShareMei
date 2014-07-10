package com.ouyang.form;

import org.apache.commons.lang3.StringUtils;

import com.ouyang.common.form.BaseForm;

/**
 * @author zishinan
 *
 */
public class UserForm extends BaseForm
{
	String name;
	String password;
	String repassword;
	String nickName;
	
	public void customValidate()
	{
		if(StringUtils.isBlank(name))
		{
			addError("name", "用户名不能为空！");
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
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getRepassword()
	{
		return repassword;
	}
	public void setRepassword(String repassword)
	{
		this.repassword = repassword;
	}
	public String getNickName()
	{
		return nickName;
	}
	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}
}
