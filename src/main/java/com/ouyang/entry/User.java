package com.ouyang.entry;

import com.ouyang.common.annotation.Entry;

@Entry
public class User
{
	private String birthday;
	private String protectid;
	private String password;
	private String phone;
	private String sex;
	private String nickname;
	private String name;
	private String ctime;
	private Long id;
	private String email;

	public String getBirthday()
	{
		return this.birthday;
	}
	public void setBirthday(String birthday)
	{
		this.birthday=birthday;
	}
	public String getProtectid()
	{
		return this.protectid;
	}
	public void setProtectid(String protectid)
	{
		this.protectid=protectid;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getSex()
	{
		return this.sex;
	}
	public void setSex(String sex)
	{
		this.sex=sex;
	}
	public String getNickname()
	{
		return this.nickname;
	}
	public void setNickname(String nickname)
	{
		this.nickname=nickname;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
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
	public String getEmail()
	{
		return this.email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}

}