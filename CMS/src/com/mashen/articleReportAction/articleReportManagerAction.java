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
@WebServlet("/articleReportManager")
public class articleReportManagerAction extends HttpServlet{
	private ArticleService as=new ArticleServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if("pass".equals(req.getParameter("action"))){
			System.out.println("pass");
			List<Article> reportPassList = as.reportPass(Integer.parseInt(req.getParameter("articleId")));
			req.setAttribute("articleReportlist", reportPassList);
		}else if("pass".equals(req.getParameter("action"))){
			System.out.println("delete");
			int articleDelete = as.articleDelete(Integer.parseInt(req.getParameter("articleId")));
			if(articleDelete!=0){
				List<Article> articleRepoertShow = as.articleRepoertShow(new Article());
				req.setAttribute("articleReportlist", articleRepoertShow);
			}
		}else if(req.getParameter("articleId")==null){
			List<Article> articleRepoertShow = as.articleRepoertShow(new Article());
			req.setAttribute("articleReportlist", articleRepoertShow);
		}
		req.setAttribute("articleReportPage", "/admin/articleReportShow.jsp");
		req.setAttribute("adminPage", "/admin/articleReportManager.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}
}
