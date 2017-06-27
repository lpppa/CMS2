package com.mashen.userController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.articleService.ArticleService;
import com.mashen.articleService.ArticleServiceImp;
import com.mashen.articleTypeService.ArticleTypeService;
import com.mashen.domian.Article;
import com.mashen.domian.User;
import com.mashen.userService.UserService;
import com.mashen.userService.UserServiceImp;
@WebServlet("/s_userMessageMainPage")
public class S_UserMessageMainPageAction extends HttpServlet{
	private UserService us=new UserServiceImp();
	private ArticleService as=new ArticleServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		System.out.println();
		user.setUserId(Integer.parseInt(req.getParameter("userId")));
		req.setAttribute("articleList", as.articleShow(new Article()));
		req.setAttribute("user", us.userShow(user).get(0));
		if("true".equals(req.getParameter("private"))){
			System.out.println("private");
			req.setAttribute("s_userPage", "/User/userMessageMainPage.jsp");
			req.getRequestDispatcher("/User/userPrivate.jsp").forward(req, resp);
		}else{
			req.setAttribute("s_userPage", "/User/userMessageMainPage.jsp");
			req.setAttribute("articlePage", "/User/userSearchMessage.jsp");
			req.getRequestDispatcher("/mainTemp.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
