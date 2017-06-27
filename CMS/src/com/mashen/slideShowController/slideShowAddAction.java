package com.mashen.slideShowController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mashen.domian.SlideShow;
import com.mashen.slideShowService.SlideShowService;
import com.mashen.slideShowService.SlideShowServiceImp;
@WebServlet("/slideShowAdd")
@MultipartConfig(location="E://img/slideshowImg")
public class slideShowAddAction extends HttpServlet{
	private SlideShowService ss=new SlideShowServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("slideShowPage", "/slideShow/slideShowAdd.jsp");
		req.setAttribute("adminPage", "/slideShow/slideShowManager.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SlideShow slideShow = new SlideShow();
		slideShow.setSlideShowName(req.getParameter("slideShowName"));
		slideShow.setSlideShowUrl(req.getParameter("slideShowUrl"));
		Part part = req.getPart("slideShowImg");
		slideShow.setSlideShowSrc("/slideShowImg/"+slideShow.getSlideShowName()+".jpg");
		ss.slideShowAdd(slideShow);
		List<SlideShow> slideShowList = ss.slideShowSearch(new SlideShow());
		part.write(slideShow.getSlideShowName()+".jpg");
		req.setAttribute("slideShowList", slideShowList);
		req.setAttribute("slideShowPage", "/slideShow/slideShowMangagerShow.jsp");
		req.setAttribute("adminPage", "/slideShow/slideShowManager.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}
	
}
