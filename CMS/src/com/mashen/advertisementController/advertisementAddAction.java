package com.mashen.advertisementController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mashen.advertisementService.AdvertisementServiceImp;
import com.mashen.domian.Advertisement;
import com.mashen.util.myProperties;

@WebServlet("/advertisementAdd")
@MultipartConfig(location="E:/img/advertisementImg/")
public class advertisementAddAction extends HttpServlet{
	private AdvertisementServiceImp as=new AdvertisementServiceImp();
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("adminPage", "/advertisement/advertisementAdd.jsp");
		req.setAttribute("advertisementPage", "/admin/articleTypeMessage.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Advertisement ad=new Advertisement();
		String advertisementName = req.getParameter("advertisementName");
		if(as.advertisementshow(advertisementName).isEmpty()){
			Part part = req.getPart("advertisementImg");
			ad.setAdvertisementName(advertisementName);
			ad.setAdvertisementUrl(req.getParameter("advertisementUrl"));
			ad.setAdvertisementImg(myProperties.getProperties("advertisementImg")+ad.getAdvertisementName()+".jpg");
			System.out.println(ad);
			int result = as.advertisementAdd(ad);
			if(result!=0){
				part.write(advertisementName+".jpg");
			}else{
				req.setAttribute("tips", "上传失败");
			}
			req.getRequestDispatcher("/advertisementShow").forward(req, resp);
		}else{
			req.setAttribute("advertisementAddTips", "该广告以存在");
			req.getRequestDispatcher("/advertisement/advertisementAdd.jsp").forward(req, resp);
		}
	}
}