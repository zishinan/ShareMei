package com.ouyang.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ouyang.common.servlet.BaseServlet;
import com.ouyang.entry.Dir;
import com.ouyang.service.DirService;
import com.ouyang.service.impl.DirServiceImpl;

@WebServlet("/dir")
public class DirServlet extends BaseServlet
{
	DirService dirService = new DirServiceImpl();
	private static final long serialVersionUID = 1L;

	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		List<Dir> list = dirService.list();
		request.setAttribute("dirs", list);
		request.getRequestDispatcher("/WEB-INF/view/dir/listDir.jsp").forward(
				request, response);
	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/view/dir/addDir.jsp").forward(
				request, response);
	}

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> map = request.getParameterMap();
		Dir dir = new Dir();
		System.out.println(dir);
		try
		{
			BeanUtils.copyProperties(dir, map);
		}
		catch (IllegalAccessException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		System.out.println(dir);
		dirService.add(dir);
		list(request, response);
	}
}
