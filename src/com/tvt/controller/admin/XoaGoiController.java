package com.tvt.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bo.PackageBO;

/**
 * @author DAO
 *
 */
@WebServlet(urlPatterns = {"/xoa-goi"})
public class XoaGoiController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String packageId = (String) req.getParameter("packageId");
		PackageBO packageBO = new PackageBO();
		packageBO.delete(packageId);
		resp.sendRedirect(req.getContextPath() + "/danh-sach-goi");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
