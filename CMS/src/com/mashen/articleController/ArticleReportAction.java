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
import com.mashen.domian.Article;

@WebServlet("/articleReport")
public class ArticleReportAction extends HttpServlet {
	private ArticleService as = new ArticleServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Article> articeList = as.articleRepoert(Integer.parseInt(req.getParameter("articleId")));
		String reportNumber = articeList.get(0).getReportNumber().toString();
		resp.getWriter().print(reportNumber);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
