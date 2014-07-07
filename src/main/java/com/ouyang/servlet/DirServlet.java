package com.ouyang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		forward(request, response,"/WEB-INF/view/dir/addDir.jsp");
	}

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		Dir dir = new Dir();
		request2Object(request, dir);
		System.out.println(dir);
		dirService.add(dir);
		list(request, response);
	}

	
}
