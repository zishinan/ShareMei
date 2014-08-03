package com.ouyang.common.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import com.ouyang.common.annotation.Validate;
import com.ouyang.common.exception.LogicException;
import com.ouyang.common.form.BaseForm;
import com.ouyang.common.upload.CFile;

/**
 * @author zishinan
 *
 */
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
		
		
		this.request = request;
		this.response = response;
	
		if (StringUtils.isNotBlank(cmd))
		{
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
						forward(null,null,errorPath);
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
	 * 封装数据并转发请求,并将title注入
	 * @param name	attribute键,没有填入null
	 * @param o		attribute值,没有填入null
	 * @param path	转发路径
	 */
	protected void forward(String name,Object o, String path)
	{
		//网页上的标题
		String title = "鲜美购ShareMei";
		request.setAttribute("ShareMeiTitle", title);
		try
		{
			if(null != name && null != o)
			{
				request.setAttribute(name, o);
			}
			request.getRequestDispatcher(path).forward(
					request, response);
		}
		catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 上传图片
	 * @param field 要上传的表单元素名称
	 * @return	上传封装文件
	 * @throws LogicException 
	 * @throws IOException 
	 */
	protected CFile upload(String field) throws LogicException, IOException
	{
		//上传文件夹
		String pathname = "upload";
		Part part = null;
		try
		{
			part = request.getPart(field);
		}
		catch (IOException | ServletException e)
		{
			throw new LogicException("上传的文件大小超出了规定大小,单个文件超过了2M,所有文件的总大小不超过了10M！");
		}
		
		if(part != null && part.getSize() > 0)
		{
			//获取文件名
			String fileName = FilenameUtils.getName(StringUtils.substringBetween(part.getHeader("Content-Disposition"), "filename=\"","\""));
			//获取后缀名
			String fileExt = FilenameUtils.getExtension(fileName);
			//从ServletContext初始化参数中获取允许上传的后缀名
			String[] allowExts = getServletContext().getInitParameter("allowExt").toLowerCase().split(",");
			if(ArrayUtils.contains(allowExts, fileExt.toLowerCase()))
			{
				throw new LogicException("上传的文件格式不符合！");
			}
			File file = new File(getServletContext().getRealPath(pathname));
			if(!file.exists() || file.isFile())
			{
				file.mkdirs();
			}
			
			String targetPath = new StringBuilder(pathname).append("/").append(System.currentTimeMillis()).append(UUID.randomUUID()).append(".").append(fileExt).toString();
			part.write(getBasePath() + targetPath);
			
			return new CFile(fileName, targetPath);
		}
		
		return null;
	}
	
	public String getBasePath()
	{
		return getServletContext().getRealPath("/");
	}

}