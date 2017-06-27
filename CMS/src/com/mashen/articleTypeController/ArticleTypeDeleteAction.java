package com.mashen.articleTypeController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.articleTypeService.ArticleTypeService;
import com.mashen.articleTypeService.ArticleTypeServiceImp;

@WebServlet("/articleTypeDetele")
public class ArticleTypeDeleteAction extends HttpServlet {
	private ArticleTypeService service = new ArticleTypeServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String articleTypeName = req.getParameter("articleTypeName");
		service.articleTypedelete(articleTypeName);
		req.setAttribute("articleTypeList", service.articleTypeGet(null));
		req.setAttribute("adminPage", "/admin/articleTypeManager.jsp");
		req.setAttribute("articleTypePage", "/admin/articleTypeMessage.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}
}
