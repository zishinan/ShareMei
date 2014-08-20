package com.ouyang.common.pagequery;

public class Page
{
	private int startPage = 0;
	private int viewNumber = 10;
	public int getStartPage()
	{
		return startPage;
	}
	public void setStartPage(int startPage)
	{
		this.startPage = startPage;
	}
	public int getViewNumber()
	{
		return viewNumber;
	}
	public void setViewNumber(int viewNumber)
	{
		this.viewNumber = viewNumber;
	}
}
