package com.ouyang.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import com.ouyang.common.exception.LogicException;
import com.ouyang.common.servlet.BaseServlet;
import com.ouyang.common.upload.CFile;
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
		
		CFile cFile = null;
		try
		{
			cFile = upload("pic_file");
		}
		catch (LogicException | IOException e1)
		{
			e1.printStackTrace();
			add();
			return;
		}
		
		if(cFile != null)
		{
			String targetPath = cFile.getPicPath();
			String smallPath = FilenameUtils.getFullPath(targetPath) + "spic/" + FilenameUtils.getName(targetPath);
			try
			{
				Thumbnails.of(new File(getBasePath(), targetPath)).size(160, 160).toFile(new File(getBasePath(), smallPath));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			product.setPic(targetPath);
			product.setSpic(smallPath);
		}
		
		try
		{
			productService.add(product);
		}
		catch (LogicException e)
		{
			e.printStackTrace();
			add();
			return;
		}
		
		list();
	}

	
}
