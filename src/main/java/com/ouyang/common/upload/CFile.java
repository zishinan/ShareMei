package com.ouyang.common.upload;

public class CFile
{
	private String fileName;
	private String picPath;
	private String spicPath;
	
	public CFile(String fileName,String picPath,String spicPath)
	{
		this.fileName = fileName;
		this.picPath = picPath;
		this.spicPath = spicPath;
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
	public String getSpicPath()
	{
		return spicPath;
	}
	public void setSpicPath(String spicPath)
	{
		this.spicPath = spicPath;
	}
}
