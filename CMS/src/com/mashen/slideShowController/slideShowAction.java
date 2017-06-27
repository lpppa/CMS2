package com.mashen.slideShowController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.domian.SlideShow;
import com.mashen.slideShowService.SlideShowService;
import com.mashen.slideShowService.SlideShowServiceImp;
@WebServlet("/slideShow")
public class slideShowAction extends HttpServlet{
	private SlideShowService ss=new SlideShowServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		List<SlideShow> slideShowList = ss.slideShowSearch(new SlideShow());
		req.setAttribute("slideShowList", slideShowList);
		req.setAttribute("slideShowPage", "/slideShow/slideShowMangagerShow.jsp");
		req.setAttribute("adminPage", "/slideShow/slideShowManager.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
