package com.ouyang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouyang.common.annotation.Validate;
import com.ouyang.common.servlet.BaseServlet;
import com.ouyang.entity.User;
import com.ouyang.form.UserForm;
import com.ouyang.service.UserService;
import com.ouyang.service.impl.UserServiceImpl;

@WebServlet("/user")
public class UserServlet extends BaseServlet
{
	UserService dirService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		super.doGet(req, resp);
	}
	public void list()
	{
		List<User> list = dirService.list();
		forward("users", list,"/WEB-INF/view/user/listUser.jsp");
	}

	public void add()
	{
		forward(null,null,"/WEB-INF/view/user/addUser.jsp");
	}

	@Validate(formClass=UserForm.class,errrorMethod="add")
	public void save()
	{
		User user = new User();
		
		
		request2Object(user);
		
		dirService.add(user);
		list();
	}
}
