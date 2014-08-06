package com.ouyang.common.upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.ouyang.common.exception.LogicException;

public class FileUtil
{
	/**
	 * @param request
	 * @param context
	 * @param field		表单元素
	 * @param pathname	上传到的目录
	 * @param allowExts	允许上传的文件后缀名（用","分隔）
	 * @return
	 * @throws LogicException
	 * @throws IOException
	 */
	public static CFile upload(HttpServletRequest request,ServletContext context,String field,String pathname,String[] allowExts) throws LogicException, IOException
	{
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
			if(!ArrayUtils.contains(allowExts, fileExt.toLowerCase()))
			{
				throw new LogicException("上传的文件格式不符合！");
			}
			File file = new File(context.getRealPath(pathname));
			if(!file.exists() || file.isFile())
			{
				file.mkdirs();
			}
			
			String targetPath = new StringBuilder(pathname).append("/").append(System.currentTimeMillis()).append(UUID.randomUUID()).append(".").append(fileExt).toString();
			part.write(context.getRealPath("/") + targetPath);
			
			return new CFile(fileName, targetPath);
		}
		return null;
	}
}
