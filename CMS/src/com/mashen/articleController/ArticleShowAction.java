package com.mashen.articleController;

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
import com.mashen.articleTypeService.ArticleTypeServiceImp;
import com.mashen.domian.Article;
import com.mashen.domian.ArticleType;

@WebServlet("/articleShow")
public class ArticleShowAction extends HttpServlet{
	private ArticleService as=new ArticleServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html,charset=utf-8");
		Article article = new Article();
		String articleId = req.getParameter("articleId");
		article.setArticleTitle(req.getParameter("s_articleTitle"));
		if(articleId!=null){
			article.setArticleId(Integer.parseInt(articleId));
			req.setAttribute("articlePage", "/article/articleRead.jsp");
			req.setAttribute("article", as.articleShow(article).get(0));
			System.out.println("1"+as.articleShow(article));
		}else{
			req.setAttribute("articlePage", "/article/articleShowAll.jsp");
			req.setAttribute("articleList", as.articleShow(article));
			System.out.println(as.articleShow(article));
		}
		req.getRequestDispatcher("mainTemp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Article article = new Article();
		article.setArticleTitle(req.getParameter("articleTitle"));
		List<Article> articleList = as.articleShow(article);
		req.setAttribute("articleList", articleList);
		req.setAttribute("articlePage", "/article/articleShowAll.jsp");
		req.getRequestDispatcher("/mainTemp.jsp").forward(req, resp);
	}
	
}
