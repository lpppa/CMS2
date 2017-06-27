package com.mashen.userController;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.mashen.domian.User;
import com.mashen.userService.UserService;
import com.mashen.userService.UserServiceImp;
@WebServlet("/login")
public class UserLoginAction extends HttpServlet{
	private UserService us = new UserServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("UTF-8");
		User user=new User();
		try {
			BeanUtils.populate(user, req.getParameterMap());
			List<User> userList=us.userLogin(user);
			if (userList.isEmpty()) {
				req.setAttribute("msg", "用户名或密码错误");
				req.getRequestDispatcher("/User/userLogin.jsp").forward(req, resp);
			}else {
				req.getSession().setAttribute("currentUser", userList.get(0));
				req.getRequestDispatcher("/mainTemp.jsp").forward(req, resp);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
