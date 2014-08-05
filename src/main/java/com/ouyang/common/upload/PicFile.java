package com.ouyang.common.upload;

public class PicFile
{
	private String fileName;
	private String picPath;
	private String spicPath;
	
	/**
	 * @param fileName	图片名
	 * @param picPath	大图目录
	 * @param spicPath	小图目录
	 */
	public PicFile(String fileName,String picPath,String spicPath)
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
