package com.ouyang.form;

import org.apache.commons.lang3.StringUtils;

import com.ouyang.common.form.BaseForm;
import com.ouyang.dao.DirDao;
import com.ouyang.dao.impl.DirDaoImpl;

/**
 * @author zishinan
 * 
 */
public class DirForm extends BaseForm
{
	String id;
	String name;
	String sn;

	public void customValidate()
	{
		DirDao dirDao = new DirDaoImpl();

		if (StringUtils.isBlank(name))
		{
			addError("name", "分类名称不能为空！");
		}
		else if (dirDao.nameExist(name))
		{
			addError("name", "分类名称已存在");
		}

		if (StringUtils.isBlank(sn) && StringUtils.isBlank(id))
		{
			addError("sn", "分类编号不能为空！");
		}
		else if (dirDao.snExist(sn) && StringUtils.isBlank(id))
		{
			addError("sn", "分类编号已存在");
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

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	
}
