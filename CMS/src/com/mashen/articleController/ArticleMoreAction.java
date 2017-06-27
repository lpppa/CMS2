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
import com.mashen.domian.PageBean;
import com.mashen.util.myProperties;
import net.sf.json.JSONArray;
@WebServlet("/articleMore")
public class ArticleMoreAction extends HttpServlet{
	private ArticleService as=new ArticleServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("走你");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Integer currentPage =  (Integer) req.getSession().getAttribute("currentPage");
		PageBean pageBean = new PageBean();
		if(currentPage==null){
			currentPage=0;
		}else{
			currentPage=currentPage+Integer.parseInt(myProperties.getProperties("articlePageNum"));
		}
		pageBean.setCurrentPage(currentPage);
		List<Article> articleList = as.articleMore(pageBean);
		JSONArray jsonData=JSONArray.fromObject(articleList.toArray());
		System.out.println(jsonData);
		System.out.println(articleList);
		resp.getWriter().print(jsonData);
		req.getSession().setAttribute("currentPage", currentPage);
		pageBean.setCurrentPage(currentPage);
	}
}
