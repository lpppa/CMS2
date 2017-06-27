package com.mashen.userController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.domian.User;
import com.mashen.userService.UserService;
import com.mashen.userService.UserServiceImp;
@WebServlet("/s_userMessagePage")
public class s_userMessagePage extends HttpServlet{
	private UserService us=new UserServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setUserId(Integer.parseInt(req.getParameter("userId")));
		List<User> userList = us.userShow(user);
		req.setAttribute("user", userList.get(0));
		if("true".equals(req.getParameter("private"))){
			System.out.println("private");
			req.setAttribute("s_userPage", "/User/userPrivateMessage.jsp");
			req.getRequestDispatcher("/User/userPrivate.jsp").forward(req, resp);
		}else{
			req.setAttribute("s_userPage", "/User/userMessagePage.jsp");
			req.getRequestDispatcher("/User/userSearchMessage.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
