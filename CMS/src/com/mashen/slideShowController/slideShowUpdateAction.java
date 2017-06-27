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

@MultipartConfig(location="E://img/slideshowImg")
@WebServlet("/slideShowUpdate")
public class slideShowUpdateAction extends HttpServlet{
	private SlideShowService ss=new SlideShowServiceImp();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SlideShow slideShow = new SlideShow();
		slideShow.setSlideShowName(req.getParameter("slideShowName"));
		slideShow.setSlideShowUrl(req.getParameter("slideShowUrl"));
		Part part = req.getPart("slideShowImg");
		slideShow.setSlideShowSrc("/slideShowImg/"+slideShow.getSlideShowName()+".jpg");
		ss.slideShowUpdate(slideShow);
		List<SlideShow> slideShowList = ss.slideShowSearch(new SlideShow());
		part.write(slideShow.getSlideShowName()+".jpg");
		req.setAttribute("slideShowList", slideShowList);
		req.setAttribute("slideShowPage", "/slideShow/slideShowMangagerShow.jsp");
		req.setAttribute("adminPage", "/slideShow/slideShowManager.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}
	
}
