package com.tvt.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bean.Service;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = {"/them-dich-vu"})
public class ThemDichVuController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/insert/them-dich-vu.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String serviceId = (String) req.getParameter("serviceId");
		String serviceName = (String) req.getParameter("serviceName");
//		String serviceType = (String) req.getParameter("serviceType");
		String serviceType = "";
		String[] type = req.getParameterValues("serviceType");
		for (int i = 0; i < type.length; i++) {
			serviceType += type[i];
		}
		
		String imageUrl = (String) req.getParameter("imageUrl");
		String price = req.getParameter("price");
		float serPrice = 0;
		try {
			serPrice = Float.parseFloat(price);
		} catch (Exception e) {
		}
		Service service = new Service(serviceId, serviceName, serviceType, imageUrl, serPrice);
		req.setAttribute("service", service);
		resp.sendRedirect(req.getContextPath() + "/danh-sach-dich-vu");
	}
}
