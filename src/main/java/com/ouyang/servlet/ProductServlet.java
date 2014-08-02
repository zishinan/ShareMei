package com.ouyang.servlet;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import org.apache.commons.lang3.StringUtils;

import com.ouyang.common.exception.LogicException;
import com.ouyang.common.servlet.BaseServlet;
import com.ouyang.entity.Dir;
import com.ouyang.entity.Product;
import com.ouyang.service.DirService;
import com.ouyang.service.ProductService;
import com.ouyang.service.impl.DirServiceImpl;
import com.ouyang.service.impl.ProductServiceImpl;

@WebServlet("/product")
@MultipartConfig
public class ProductServlet extends BaseServlet
{
	DirService dirService = new DirServiceImpl();
	ProductService productService = new ProductServiceImpl();
	private static final long serialVersionUID = 1L;

	public void list()
	{
		List<Product> list = productService.list();
		forward("products", list,"/WEB-INF/view/product/listProduct.jsp");
	}

	public void add()
	{
		List<Dir> list = dirService.list();
		forward("dirs", list,"/WEB-INF/view/product/editProduct.jsp");
	}

	public void save()
	{
		System.out.println("save ==============");
		Product product = new Product();
		request2Object(product);
		String dir_id = request.getParameter("dir_id");
		if(StringUtils.isNotBlank(dir_id))
		{
			Dir dir = new Dir();
			dir.setId(Long.parseLong(dir_id));
			product.setDir(dir);
		}
		try
		{
			productService.add(product);
		}
		catch (LogicException e)
		{
			forward("errorMsg", e.getMessage(),"/WEB-INF/view/error.jsp");
			e.printStackTrace();
		}
		list();
	}

	
}
