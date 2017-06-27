package com.mashen.advertisementController;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.advertisementService.AdvertisementServiceImp;
import com.mashen.domian.Advertisement;
@WebServlet("/advertisementShow")
public class advertisementShowAction extends HttpServlet{
	private AdvertisementServiceImp as=new AdvertisementServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		List<Advertisement> advertisementList = as.advertisementshow(null);
		req.setAttribute("advertisementList", advertisementList);
		req.setAttribute("adminPage", "/advertisement/advertisementShow.jsp");
		req.setAttribute("advertisementPage", "/admin/articleTypeMessage.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Advertisement> advertisementList = as.advertisementshow(req.getParameter("s_advertisementName"));
		req.setAttribute("advertisementList", advertisementList);
		req.setAttribute("adminPage", "/advertisement/advertisementShow.jsp");
		req.setAttribute("advertisementPage", "/admin/articleTypeMessage.jsp");
		req.getRequestDispatcher("/admin/maintemp.jsp").forward(req,resp);
	}
}
