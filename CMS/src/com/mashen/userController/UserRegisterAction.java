package com.mashen.userController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.mashen.domian.User;
import com.mashen.userService.UserService;
import com.mashen.userService.UserServiceImp;
@WebServlet("/userRegister")
public class UserRegisterAction extends HttpServlet{
	private UserService us = new UserServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			User registerUser=null;	
			try {
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.populate(registerUser, req.getParameterMap());
					if(registerUser!=null){
						req.getRequestDispatcher("/User/userRegister.jsp").forward(req, resp);
					}else{
						req.getRequestDispatcher("/mainTemp.jsp").forward(req, resp);
					}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
