package com.ouyang.entity;

import java.util.Date;
import com.ouyang.common.annotation.Entry;

@Entry
public class User
{
	private Long id;
	private String birthday;
	private String sex;
	private String phone;
	private String nickname;
	private String email;
	private String name;
	private Date ctime;

	public Long getId()
	{
		return this.id;
	}
	public void setId(Long id)
	{
		this.id=id;
	}
	public String getBirthday()
	{
		return this.birthday;
	}
	public void setBirthday(String birthday)
	{
		this.birthday=birthday;
	}
	public String getSex()
	{
		return this.sex;
	}
	public void setSex(String sex)
	{
		this.sex=sex;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getNickname()
	{
		return this.nickname;
	}
	public void setNickname(String nickname)
	{
		this.nickname=nickname;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
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