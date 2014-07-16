package com.ouyang.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.apache.commons.lang3.StringUtils;

import com.ouyang.common.annotation.Validate;
import com.ouyang.common.exception.LogicException;
import com.ouyang.common.servlet.BaseServlet;
import com.ouyang.entity.Dir;
import com.ouyang.form.DirForm;
import com.ouyang.service.DirService;
import com.ouyang.service.impl.DirServiceImpl;

@WebServlet("/dir")
public class DirServlet extends BaseServlet
{
	DirService dirService = new DirServiceImpl();
	private static final long serialVersionUID = 1L;

	public void list()
	{
		List<Dir> list = dirService.list();

		forward("dirs", list, "/WEB-INF/view/dir/listDir.jsp");
	}

	public void update()
	{
		Dir dir = null;
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id))
		{
			dir = dirService.getById(Long.parseLong(id));
		}
		request.setAttribute("dir", dir);
		List<Dir> dirs = dirService.list();
		forward("dirs", dirs, "/WEB-INF/view/dir/editDir.jsp");
	}

	public void add()
	{
		List<Dir> dirs = dirService.list();
		forward("dirs", dirs, "/WEB-INF/view/dir/editDir.jsp");
	}

	public void delete()
	{
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id))
		{
			dirService.delete(Long.parseLong(id));
		}
		list();
	}

	@Validate(errrorMethod = "add", formClass = DirForm.class)
	public void save()
	{
		String id = request.getParameter("id");
		Dir dir = null;
		if (StringUtils.isNotBlank(id))
		{
			dir = dirService.getById(Long.parseLong(id));
		}
		else
		{
			dir = new Dir();
		}

		request2Object(dir);
		String dir_id = request.getParameter("dir_id");
		if (StringUtils.isNotBlank(dir_id))
		{
			Dir superDir = new Dir();
			superDir.setId(Long.parseLong(dir_id));
			dir.setDir(superDir);
		}
		try
		{
			if (StringUtils.isNotBlank(id))
			{
				dirService.update(dir);
			}
			else
			{
				dirService.add(dir);
			}
		}
		catch (LogicException e)
		{
			forward("errorMsg", e.getMessage(), "/WEB-INF/view/error.jsp");
			return;
		}
		list();
	}

}
