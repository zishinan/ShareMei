package com.ouyang.common.upload;

public class CFile
{
	private String fileName;
	private String targetPath;
	
	public CFile(String fileName, String targetPath)
	{
		this.fileName = fileName;
		this.targetPath = targetPath;
	}
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getTargetPath()
	{
		return targetPath;
	}
	public void setTargetPath(String targetPath)
	{
		this.targetPath = targetPath;
	}
}
