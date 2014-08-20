package com.ouyang.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import com.ouyang.common.annotation.Validate;
import com.ouyang.common.exception.LogicException;
import com.ouyang.common.servlet.BaseServlet;
import com.ouyang.common.upload.PicFile;
import com.ouyang.entity.Dir;
import com.ouyang.entity.Product;
import com.ouyang.form.ProductForm;
import com.ouyang.form.query.QueryProductForm;
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
		QueryProductForm queryProductForm = new QueryProductForm();
		request2Object(queryProductForm);
		
		
		
		List<Dir> dirs = dirService.list();
		request.setAttribute("dirs", dirs);
		List<Product> list = productService.list();
		forward("products", list,"/WEB-INF/view/product/listProduct.jsp");
	}

	public void add()
	{
		List<Dir> list = dirService.list();
		forward("dirs", list,"/WEB-INF/view/product/editProduct.jsp");
	}

	@Validate(errrorMethod="add",formClass=ProductForm.class)
	public void save()
	{
		Product product = null;
		
		String id = request.getParameter("id");
		if(StringUtils.isBlank(id))
		{
			product = new Product();
		}
		else 
		{
			product =  productService.getById(NumberUtils.toLong(id));
		}
		
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
				deleteProductPic(product);
				product.setPic(picFile.getPicPath());
				product.setSpic(picFile.getSpicPath());
			}
			
			if(StringUtils.isBlank(id))
			{
				productService.add(product);
			}
			else
			{
				productService.update(product);
			}
		}
		catch (LogicException | IOException e)
		{
			log.debug(e.getMessage());
			deleteProductPic(product);
			add();
			return;
		}
		list();
	}
	
	public void delete()
	{
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id))
		{
			Long productId = Long.parseLong(id);
			Product product = productService.getById(productId);
			deleteProductPic(product);
			productService.delete(productId);
		}
		list();
	}

	private void deleteProductPic(Product product)
	{
		String picPath = product.getPic();
		if(StringUtils.isNotBlank(picPath))
		{
			new File(getBasePath(),picPath).delete();
			new File(getBasePath(),product.getSpic()).delete();
		}
	}

	public void update()
	{
		Product product = null;
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id))
		{
			product = productService.getById(Long.parseLong(id));
		}
		request.setAttribute("product", product);
		List<Dir> dirs = dirService.list();
		forward("dirs", dirs, "/WEB-INF/view/product/editProduct.jsp");
	}

	
}
