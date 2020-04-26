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
 * @author DAO
 *
 */
@WebServlet(urlPatterns = {"/them-goi"})
public class ThemGoiController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/insert/them-goi.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PackageBOImpl packageBO = new PackageBOImpl();
		req.setCharacterEncoding("UTF-8");
		String packageId = (String) req.getParameter("packageId");
		String packageName = (String) req.getParameter("packageName");
		String packageType = (String) req.getParameter("packageType");
		String packagePrice = (String) req.getParameter("price");
		float chuyenDoiGia = 0;
		try {
			chuyenDoiGia = Float.parseFloat(packagePrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Package package1 = new Package(packageId, packageName, packageType, chuyenDoiGia);
		packageBO.insert(package1);
		req.setAttribute("package", package1);
		resp.sendRedirect(req.getContextPath() + "/danh-sach-goi");
	}
}
