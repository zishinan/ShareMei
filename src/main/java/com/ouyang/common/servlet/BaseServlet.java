package com.ouyang.common.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

public abstract class BaseServlet extends HttpServlet
{

	public BaseServlet()
	{
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
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

	protected abstract void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * 将表单数据拷贝到对象
	 * @param request
	 * @param object
	 */
	protected void request2Object(HttpServletRequest request, Object object)
	{
		Map<String, String[]> map = request.getParameterMap();
		try
		{
			BeanUtils.copyProperties(object, map);
		}
		catch (IllegalAccessException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 将请求转发到新地址
	 * @param request
	 * @param response
	 * @param path
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void forward(HttpServletRequest request,
			HttpServletResponse response, String path) throws ServletException, IOException
	{
		request.getRequestDispatcher(path).forward(
				request, response);
	}

}