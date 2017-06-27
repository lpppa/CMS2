package com.mashen.articleTypeController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.articleTypeService.ArticleTypeService;
import com.mashen.articleTypeService.ArticleTypeServiceImp;
import com.mashen.domian.Article;
import com.mashen.domian.ArticleType;
@WebServlet("/searchByArticleType")
public class SearchByArticleType extends HttpServlet{
	private ArticleTypeService as=new ArticleTypeServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		List<Article> articleList = as.searchByArticleTypeName(Integer.parseInt(req.getParameter("articleTypeId")));
		req.setAttribute("articleList", articleList);
		req.setAttribute("articlePage", "/article/articleShowAll.jsp");
		req.getRequestDispatcher("mainTemp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
