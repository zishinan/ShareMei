package com.ouyang.servlet;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

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

	public void list()
	{
		List<User> list = dirService.list();
		request.setAttribute("users", list);
		forward("/WEB-INF/view/user/listUser.jsp");
	}

	public void add()
	{
		forward("/WEB-INF/view/user/addUser.jsp");
	}

	public void save()
	{
		UserForm userForm = new UserForm();
		request2Object(userForm);
		
		if(!userForm.validate())
		{
			Map<String, String> errors = userForm.getErrors();
			request.setAttribute("errors", errors);
			add();
		}
		
		User user = new User();
		
		
		request2Object(user);
		
		dirService.add(user);
		list();
	}
}
