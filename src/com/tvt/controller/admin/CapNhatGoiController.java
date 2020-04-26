package com.tvt.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bean.Package;
import com.tvt.model.bo.PackageBOImpl;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = {"/cap-nhat-goi"})
public class CapNhatGoiController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PackageBOImpl packageBO = new PackageBOImpl();
		String packageId = (String) req.getParameter("packageId");
		
		Package package1 = null;
		
		try {
			package1 = packageBO.getAllById(packageId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (package1 == null) {
			resp.sendRedirect(req.getContextPath() + "/danh-sach-goi");
			return;
		}
		
		req.setAttribute("package1", package1);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/update/cap-nhat-goi.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PackageBOImpl packageBO = new PackageBOImpl();
		
		req.setCharacterEncoding("UTF-8");
		String packageId = (String) req.getParameter("packageId");
		String packageName = (String) req.getParameter("packageName");
		String packageType = "";
		String[] type = req.getParameterValues("packageType");
		for (int i = 0; i < type.length; i++) {
			packageType += type[i];
		}
		String price = (String) req.getParameter("price");
		float doiGia = 0;
		try {
			doiGia = Float.parseFloat(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Package package1 = null;
		try {
			package1 = new Package(packageId, packageName, packageType, doiGia);
			packageBO.update(package1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("package1", package1);
		resp.sendRedirect(req.getContextPath() + "/danh-sach-goi");
	}
}
