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
import javax.servlet.http.HttpSession;

import com.tvt.model.bean.Package;
import com.tvt.model.bo.PackageBO;

/**
 * @author DAO
 *
 */
@WebServlet(urlPatterns = {"/danh-sach-goi"})
public class DanhSachGoiController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
        if (session.getAttribute("thongTinTaiKhoan") == null) {
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }
		PackageBO packageBO = new PackageBO();
		List<Package> packageList = new ArrayList<Package>();
		try {
		packageList = packageBO.getAll();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		req.setAttribute("packageList", packageList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list/danh-sach-goi.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
