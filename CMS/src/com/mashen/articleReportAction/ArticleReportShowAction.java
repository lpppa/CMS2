package com.mashen.articleReportAction;

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
@WebServlet("/articleReportShow")
public class ArticleReportShowAction extends HttpServlet{
	 private ArticleService service=new ArticleServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Article> articleReportlist = service.articleRepoertShow(new Article());
		System.out.println(articleReportlist);
		req.setAttribute("articleReportlist", articleReportlist);
		req.setAttribute("articleReportPage", "/admin/articleReportShow.jsp");
		req.setAttribute("adminPage", "/admin/articleReportManager.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}
}
