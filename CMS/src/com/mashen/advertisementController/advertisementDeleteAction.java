package com.mashen.advertisementController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.advertisementService.AdvertisementService;
import com.mashen.advertisementService.AdvertisementServiceImp;
@WebServlet("/advertisementDelete")
public class advertisementDeleteAction extends HttpServlet{
	private AdvertisementService as=new AdvertisementServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String advertisementId = req.getParameter("advertisementId");
		as.advertisementDelete(Integer.parseInt(advertisementId));
		req.getRequestDispatcher("advertisementShow").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
