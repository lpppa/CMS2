package com.mashen.advertisementController;

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

import com.mashen.advertisementService.AdvertisementServiceImp;
import com.mashen.domian.Advertisement;
import com.mashen.util.myProperties;
@WebServlet("/advertisementUpdata")
@MultipartConfig(location="E:/img/advertisementImg/")
public class advertisementUpdateAction extends HttpServlet{
	
	private AdvertisementServiceImp as=new AdvertisementServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String advertisementName = req.getParameter("advertisementName");
		List<Advertisement> advertisement = as.advertisementshow(advertisementName);
		req.setAttribute("advertisement", advertisement.get(0));
		req.setAttribute("adminPage", "/advertisement/advertisementUpdate.jsp");
		req.setAttribute("advertisementPage", "/admin/articleTypeMessage.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Advertisement advertisement = new Advertisement();
		try {
			BeanUtils.populate(advertisement, req.getParameterMap());
			Part part = req.getPart("advertisementImg");
			advertisement.setAdvertisementImg(myProperties.getProperties("advertisementImg")+advertisement.getAdvertisementName()+".jpg");
			int result = as.advertisementUpdata(advertisement);
			if(result!=0){
				req.getRequestDispatcher("advertisementShow").forward(req, resp);
				part.write(advertisement.getAdvertisementName()+".jpg");
			}else{
				req.setAttribute("tips", "修改失败");
				req.getRequestDispatcher("advertisementUpdata.jsp").forward(req, resp);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
