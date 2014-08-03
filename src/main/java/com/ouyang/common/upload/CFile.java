package com.ouyang.common.upload;

public class CFile
{
	private String fileName;
	private String picPath;
	
	/**
	 * @param fileName	文件名
	 * @param picPath	上传路径
	 */
	public CFile(String fileName,String picPath)
	{
		this.fileName = fileName;
		this.picPath = picPath;
	}
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getPicPath()
	{
		return picPath;
	}
	public void setPicPath(String picPath)
	{
		this.picPath = picPath;
	}
}
