package com.mashen.mainPageController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.mashen.advertisementService.AdvertisementService;
import com.mashen.advertisementService.AdvertisementServiceImp;
import com.mashen.articleService.ArticleService;
import com.mashen.articleService.ArticleServiceImp;
import com.mashen.articleTypeService.ArticleTypeService;
import com.mashen.articleTypeService.ArticleTypeServiceImp;
import com.mashen.domian.Article;
import com.mashen.domian.SlideShow;
import com.mashen.domian.User;
import com.mashen.slideShowService.SlideShowService;
import com.mashen.slideShowService.SlideShowServiceImp;
import com.mashen.userService.UserService;
import com.mashen.userService.UserServiceImp;
@WebServlet("/mainPage")
public class mainPageAction extends HttpServlet{
	private ArticleTypeService articleTypeS=new ArticleTypeServiceImp();
	private AdvertisementService ads=new AdvertisementServiceImp();
	private ArticleService articleS=new ArticleServiceImp();
	private UserService us = new UserServiceImp();
	private SlideShowService ss=new SlideShowServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		session.setAttribute("articleTypeList", articleTypeS.articleTypeGet(null));
		if(session.getAttribute("currentUser")==null){
			session.setAttribute("loginPage","/User/userLogin.jsp");
		}else{
			session.setAttribute("loginPage","/User/afterLogin.jsp");
		}
		req.setAttribute("articleList", articleS.articleShow(new Article()));
		List<SlideShow> slideShowList = ss.slideShowSearch(new SlideShow());
		req.getSession().setAttribute("slideShowList", slideShowList);
		req.getSession().setAttribute("slideShowPage", "/slideShow/slideShow.jsp");
		session.setAttribute("advertisementList", ads.advertisementshow(null));
		session.setAttribute("articlePage", "/article/articleShowAll.jsp");
		req.getRequestDispatcher("mainTemp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if("true".equals(req.getParameter("login"))){
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("UTF-8");
			User user=new User();
			try {
				BeanUtils.populate(user, req.getParameterMap());
				List<User> userList=us.userLogin(user);
				if (userList.isEmpty()) {
					req.setAttribute("msg", "用户名或密码错误");
					req.getRequestDispatcher("/User/userLogin.jsp").forward(req, resp);
				}else {
					req.getSession().setAttribute("currentUser", userList.get(0));
					System.out.println("已登录"+userList.get(0));
					this.doGet(req, resp);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
