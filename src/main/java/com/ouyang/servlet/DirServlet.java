package com.ouyang.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.ouyang.common.servlet.BaseServlet;
import com.ouyang.entry.Dir;
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
		request.setAttribute("dirs", list);
		
		forward("/WEB-INF/view/dir/listDir.jsp");
	}

	public void add()
	{
		forward("/WEB-INF/view/dir/addDir.jsp");
	}

	public void save()
	{
		Dir dir = new Dir();
		request2Object(dir);
		System.out.println(dir);
		dirService.add(dir);
		list();
	}

	
}
