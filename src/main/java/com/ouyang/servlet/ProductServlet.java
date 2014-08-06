package com.ouyang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.ouyang.common.exception.LogicException;
import com.ouyang.common.servlet.BaseServlet;
import com.ouyang.common.upload.PicFile;
import com.ouyang.entity.Dir;
import com.ouyang.entity.Product;
import com.ouyang.service.DirService;
import com.ouyang.service.ProductService;
import com.ouyang.service.impl.DirServiceImpl;
import com.ouyang.service.impl.ProductServiceImpl;

@WebServlet("/product")
@MultipartConfig(maxFileSize=1024*1024*2,maxRequestSize=1024*1024*10)
public class ProductServlet extends BaseServlet
{
	Logger log = Logger.getLogger(ProductServlet.class);
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
		Product product = new Product();
		request2Object(product);
		String dir_id = request.getParameter("dir_id");
		if(StringUtils.isNotBlank(dir_id))
		{
			Dir dir = new Dir();
			dir.setId(Long.parseLong(dir_id));
			product.setDir(dir);
		}
		
		
		PicFile picFile = null;
		try
		{
			picFile = upload("pic_file");
			if(picFile != null)
			{
				product.setPic(picFile.getPicPath());
				product.setSpic(picFile.getSpicPath());
			}
			
			productService.add(product);
		}
		catch (LogicException | IOException e)
		{
			System.out.println("================");
			log.debug(e.getMessage());
			add();
			return;
		}
		list();
	}

	
}
