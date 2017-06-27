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
import com.mashen.domian.ArticleType;

@WebServlet("/articleTypeShowAll")
public class ArticleTypeShowAllController extends HttpServlet{
	private ArticleTypeService as=new ArticleTypeServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ArticleType> articleTypeList = as.articleTypeGet(null);
		String page = req.getParameter("page");
		req.getSession().setAttribute("articleTypeList", articleTypeList);
		if("admin".equals(page)){
			req.setAttribute("adminPage", "/admin/articleTypeManager.jsp");
			req.setAttribute("articleTypePage", "/admin/articleTypeMessage.jsp");
			req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ArticleType> articleTypeList = as.articleTypeGet(req.getParameter("s_articleTypeName"));
		req.setAttribute("adminPage", "/admin/articleTypeManager.jsp");
		req.setAttribute("articleTypePage", "/admin/articleTypeMessage.jsp");
		if(articleTypeList.isEmpty()){
				req.setAttribute("admin_articleType_search_msg", "栏目不存在！");
		}
		req.setAttribute("articleTypeList", articleTypeList);
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}
	

}
