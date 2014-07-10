package com.ouyang.servlet;

import javax.servlet.annotation.WebServlet;

import com.ouyang.common.servlet.BaseServlet;

@WebServlet("/")
public class IndexServlet extends BaseServlet
{
	private static final long serialVersionUID = 424192481903743911L;

	@Override
	protected void list()
	{
		forward("/WEB-INF/view/index.jsp");
	}
}
