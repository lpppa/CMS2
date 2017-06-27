package com.mashen.userController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.domian.User;
import com.mashen.userService.UserService;
import com.mashen.userService.UserServiceImp;
@WebServlet("/userCheck")
public class UserCheckAction extends HttpServlet{
	private UserService us = new UserServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		User registerUser=new User();
		String registerUserAccount = req.getParameter("userAccount");
		System.out.println("xxx"+registerUserAccount);
		String registerUsername = req.getParameter("userName");
		if(registerUserAccount!=null){
			registerUser.setUserAccount(registerUserAccount);
			checkAccount(registerUser,resp);
		}
		if(registerUsername!=null){
			registerUser.setUserName(registerUsername);
			checkUserName(registerUser, resp);
		}
		
		
	}
	private void checkAccount(User registerUser,HttpServletResponse resp) throws IOException{
		List<User> userList = us.userCheck(registerUser);
			if (userList.isEmpty()) {
				resp.getWriter().print("userAccountTrue");
				return;
			}
		resp.getWriter().print("userAccountFalse");
		}
	
	private void checkUserName(User registerUser,HttpServletResponse resp) throws IOException{
		List<User> userList = us.userCheck(registerUser);
			if ( userList.isEmpty()){
				resp.getWriter().print("userNameTrue");
				return;
			} 
		resp.getWriter().print("userNameFalse");
	}
}
	

