package com.ouyang.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.ouyang.common.annotation.Validate;
import com.ouyang.common.exception.LogicException;
import com.ouyang.common.servlet.BaseServlet;
import com.ouyang.entity.Dir;
import com.ouyang.form.ProductForm;
import com.ouyang.service.DirService;
import com.ouyang.service.impl.DirServiceImpl;

@WebServlet("/product")
public class ProductServlet extends BaseServlet
{
	DirService dirService = new DirServiceImpl();
	private static final long serialVersionUID = 1L;

	public void list()
	{
		List<Dir> list = dirService.list();
		forward("dirs", list,"/WEB-INF/view/dir/listProduct.jsp");
	}

	@Validate(formClass=ProductForm.class)
	public void add()
	{
		List<Dir> list = dirService.list();
		forward("dirs", list,"/WEB-INF/view/product/addProduct.jsp");
	}

	public void save()
	{
		Dir dir = new Dir();
		request2Object(dir);
		System.out.println(dir);
		try
		{
			dirService.add(dir);
		}
		catch (LogicException e)
		{
			forward("errorMsg", e.getMessage(),"/WEB-INF/view/error.jsp");
			e.printStackTrace();
		}
		list();
	}

	
}