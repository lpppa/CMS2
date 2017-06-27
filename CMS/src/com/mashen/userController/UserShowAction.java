package com.mashen.userController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.domian.PageBean;
import com.mashen.domian.User;
import com.mashen.userService.UserService;
import com.mashen.userService.UserServiceImp;
@WebServlet("/userShow")
public class UserShowAction extends HttpServlet{
	private UserService us=new UserServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s_adminUserAccount = req.getParameter("s_adminUserAccount");
		User user = new User();
		if(s_adminUserAccount==null || "".equals(s_adminUserAccount)){
			user.setUserAccount(s_adminUserAccount);
			List<User> userList = us.userShow(user);
			req.setAttribute("userList", userList);
			req.setAttribute("adminPage", "/admin/userManager.jsp");
			req.setAttribute("userMessagePage", "/admin/userMessage.jsp");
			req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
		}else{
			List<User> userList = us.userShow(user);
			req.setAttribute("userList", userList);
			if(userList.isEmpty()){
				req.setAttribute("admin_user_search_msg", "用户不存在！");
			}
			req.setAttribute("adminPage", "/admin/userManager.jsp");
			req.setAttribute("userMessagePage", "/admin/userMessage.jsp");
			req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setUserName(req.getParameter("s_adminUserName"));
		List<User> userList=us.userShow(user);
		req.setAttribute("userList", userList);
		if(userList.isEmpty()){
			req.setAttribute("admin_user_search_msg", "用户不存在！");
		}
		req.setAttribute("userMessagePage", "/admin/userMessage.jsp");
		req.setAttribute("adminPage", "/admin/userManager.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}
}
