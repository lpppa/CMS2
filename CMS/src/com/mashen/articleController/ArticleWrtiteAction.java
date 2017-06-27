package com.mashen.articleController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.jasper.xmlparser.SymbolTable;

import com.mashen.articleService.ArticleService;
import com.mashen.articleService.ArticleServiceImp;
import com.mashen.articleTypeService.ArticleTypeService;
import com.mashen.articleTypeService.ArticleTypeServiceImp;
import com.mashen.domian.Article;
import com.mashen.domian.ArticleType;
import com.mashen.domian.User;
import com.mashen.util.myProperties;
@WebServlet("/articleWrite")
@MultipartConfig(location="E:/img/articleImg")
public class ArticleWrtiteAction extends HttpServlet{
	private ArticleService as=new ArticleServiceImp();
	private ArticleTypeService ats=new ArticleTypeServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ArticleType> articleTypeList = ats.articleTypeGet(null);
		req.setAttribute("articleTypeList", articleTypeList);
		req.setAttribute("articlePage", "/article/articleWrite.jsp");
		req.getRequestDispatcher("/mainTemp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		User currentUser = (User) req.getSession().getAttribute("currentUser");
		Article article=new Article();
		if(currentUser!=null){
			article.setUserAccountId(currentUser.getUserId());
		}else{
			req.setAttribute("msg", "请登录");
			req.getRequestDispatcher("/User/userLogin.jsp").forward(req, resp);
		}
		article.setArticleContent((req.getParameter("articleContent")));
		article.setArticleTitle(req.getParameter("articleTitle"));
		article.setAricleTypeId(Integer.parseInt(req.getParameter("aricleTypeId")));
		article.setUserAccountId(Integer.parseInt(req.getParameter("userAccountId")));
		Part part = req.getPart("articlepicture");
		String saveName=article.getArticleTitle()+".jpg";
		article.setarticlepicture(myProperties.getProperties("articleImg")+saveName);
		if(as.articleWriter(article)!=0){
			part.write(saveName);
			List<Article> articleList = as.articleShow(new Article());
			req.setAttribute("articleList", articleList);
			req.setAttribute("s_userPage", "/User/userMessageMainPage.jsp");
			req.setAttribute("articlePage", "/User/userSearchMessage.jsp");
			req.getRequestDispatcher("/mainTemp.jsp").forward(req, resp);
		}else{
			System.out.println("上传失败");
		}
	}
}
