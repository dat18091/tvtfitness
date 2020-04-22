package com.tvt.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet(urlPatterns = { "/danh-sach-dich-vu" })
public class DanhSachDichVuController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Service> serviceList = new ArrayList<Service>();
		ServiceBOImpl serviceBOImpl = new ServiceBOImpl();
		serviceList = serviceBOImpl.getAll();
		req.setAttribute("serviceList", serviceList);
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/views/admin/list/danh-sach-dich-vu.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
