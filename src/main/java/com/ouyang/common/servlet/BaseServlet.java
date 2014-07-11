package com.ouyang.common.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import com.ouyang.common.annotation.Validate;
import com.ouyang.common.form.BaseForm;
import com.ouyang.form.UserForm;

public abstract class BaseServlet extends HttpServlet
{
	private static final long serialVersionUID = -5234775202951986769L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	public BaseServlet()
	{
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		Method method = MethodUtils.getAccessibleMethod(this.getClass(), cmd);
		if(method.isAnnotationPresent(Validate.class))
		{
			Validate validate = method.getAnnotation(Validate.class);
			BaseForm baseForm = null;
			try
			{
				baseForm = (BaseForm) validate.formClass().newInstance();
			}
			catch (InstantiationException | IllegalAccessException e)
			{
				e.printStackTrace();
			}
			request2Object(baseForm);
			
			if(!baseForm.validate())
			{
				Map<String, String> errors = baseForm.getErrors();
				request.setAttribute("errors", errors);
				String errorPath = validate.errorPath();
				String errorMethod = validate.errrorMethod();
				if(errorPath.length() > 0)
				{
					forward(errorPath);
					return;
				}
				else if(errorMethod.length() > 0)
				{
					try
					{
						MethodUtils.invokeExactMethod(this, errorMethod);
					}
					catch (NoSuchMethodException | IllegalAccessException
							| InvocationTargetException e)
					{
						e.printStackTrace();
					}
					return;
				}
				else 
				{
					throw new RuntimeException("必须指定一个错误页面或者错误方法！");
				}
			}
		}
		
		this.request = request;
		this.response = response;
	
		if (StringUtils.isNotBlank(cmd))
		{
			try
			{
				MethodUtils.invokeMethod(this, cmd);
			}
			catch (NoSuchMethodException | IllegalAccessException
					| InvocationTargetException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			list();
		}
	}

	protected abstract void list();
	
	/**
	 * 将表单数据拷贝到对象
	 * @param request
	 * @param object
	 */
	protected void request2Object(Object object)
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
	protected void forward(String path)
	{
		try
		{
			request.getRequestDispatcher(path).forward(
					request, response);
		}
		catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
	}

}