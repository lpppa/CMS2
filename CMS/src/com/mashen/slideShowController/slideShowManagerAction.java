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
@WebServlet("/slideShowManager")
public class slideShowManagerAction extends HttpServlet{
	private SlideShowService ss=new SlideShowServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SlideShow slideShow = new SlideShow();
		if("update".equals(req.getParameter("action"))){
			slideShow.setSlideShowId(Integer.parseInt(req.getParameter("slideShowId")));
			List<SlideShow> slideShowList = ss.slideShowSearch(slideShow);
			req.setAttribute("slideShowList", slideShowList);
			req.setAttribute("slideShowPage", "/slideShow/slideShowUpdate.jsp");
		}else if("delete".equals(req.getParameter("action"))){
			ss.slideShowDelete(Integer.parseInt(req.getParameter("slideShowId")));
			List<SlideShow> slideShowList = ss.slideShowSearch(slideShow);
			req.setAttribute("slideShowList", slideShowList);
			req.setAttribute("slideShowPage", "/slideShow/slideShowMangagerShow.jsp");
		}else if("showing".equals(req.getParameter("action"))){
			List<SlideShow> slideShowing = ss.slideShowing();
			if(slideShowing.get(0).getShowingNumber()>5){
				req.setAttribute("slideShowTips", "轮播图已达到最大推送数");
				System.out.println("?");
			}else{
				List<SlideShow> slideShouList = ss.slideShouPush(Integer.parseInt(req.getParameter("slideShowId")));
				System.out.println("showing"+slideShouList);
				req.setAttribute("slideShowList", slideShouList);
				req.setAttribute("slideShowPage", "/slideShow/slideShowMangagerShow.jsp");
			}
		}else if("off".equals(req.getParameter("action"))){
			List<SlideShow> slideShouList = ss.slideShouPushOff(Integer.parseInt(req.getParameter("slideShowId")));
			System.out.println("off"+slideShouList);
			req.setAttribute("slideShowList", slideShouList);
			req.setAttribute("slideShowPage", "/slideShow/slideShowMangagerShow.jsp");
		}
		req.setAttribute("adminPage", "/slideShow/slideShowManager.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}
}
