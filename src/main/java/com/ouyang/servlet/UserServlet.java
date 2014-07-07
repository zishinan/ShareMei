package com.ouyang.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import com.ouyang.entry.User;
import com.ouyang.service.UserService;
import com.ouyang.service.impl.UserServiceImpl;

@WebServlet("/user")
public class UserServlet extends HttpServlet
{
	UserService dirService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");

		if (StringUtils.isNotBlank(cmd))
		{
			try
			{
				MethodUtils.invokeMethod(this, cmd, request, response);
			}
			catch (NoSuchMethodException | IllegalAccessException
					| InvocationTargetException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			list(request, response);
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		List<User> list = dirService.list();
		request.setAttribute("users", list);
		request.getRequestDispatcher("/WEB-INF/view/user/listUser.jsp").forward(
				request, response);
	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/view/user/addUser.jsp").forward(
				request, response);
	}

	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		System.out.println(user);
		try
		{
			BeanUtils.copyProperties(user, map);
		}
		catch (IllegalAccessException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		System.out.println(user);
		dirService.add(user);
		list(request, response);
	}
}
