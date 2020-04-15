package com.tvt.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bean.Service;
import com.tvt.model.bo.ServiceBOImpl;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = {"/cap-nhat-dich-vu"})
public class CapNhatDichVuController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/update/cap-nhat-dich-vu.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceBOImpl serviceBOImpl = new ServiceBOImpl();
		
		req.setCharacterEncoding("UTF-8");
		String serviceId = (String) req.getParameter("serviceId");
		String serviceName = (String) req.getParameter("serviceName");
		String serviceType = "";
		String[] type = req.getParameterValues("serviceType");
		for (int i = 0; i < type.length; i++) {
			serviceType += type[i];
		}
		String imageUrl = (String) req.getParameter("imageUrl");
		String price = req.getParameter("price");
		float sprice = 0;
		try {
			sprice = Float.parseFloat(price);
		} catch (Exception e) {
		}
		Service service = new Service(serviceId, serviceName, serviceType, imageUrl, sprice);
		serviceBOImpl.update(service);
		req.setAttribute("service", service);
		resp.sendRedirect(req.getContextPath() + "/danh-sach-dich-vu");
	}
}
