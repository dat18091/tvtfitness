package com.tvt.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tvt.model.bo.RegisterServiceBO;

/**
 * Servlet implementation class DangKyDichVu
 */
@WebServlet("/dang-ky-dich-vu")
public class DangKyDichVu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKyDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiem tra da dang nhap chua
		HttpSession session = request.getSession();
		if (session.getAttribute("thongTinTaiKhoan") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		RegisterServiceBO registerServiceBO = new RegisterServiceBO();

		if ("submit".equals(request.getParameter("submit"))) {
			String maDv = request.getParameter("maDv");
			String maTv = request.getParameter("maTv");
			String registerDate = request.getParameter("thoiGian");
			String chiPhi = request.getParameter("chiPhi");
			registerServiceBO.insert(maDv, maTv, registerDate, chiPhi);
			response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-dich-vu");
		} else if ("cancel".equals(request.getParameter("cancel"))) {
			response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-dich-vu");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/insert/dang-ky-dich-vu.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
