package com.tvt.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bo.RegisterClassBo;

/**
 * Servlet implementation class CapNhatDangKiLopTap
 */
@WebServlet("/cap-nhat-dang-ky-lop")
public class CapNhatDangKiLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatDangKiLopTap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RegisterClassBo registerClassBo = new RegisterClassBo();
		String classId = request.getParameter("classId");
		String memberId = request.getParameter("memberId");
		
		if ("submit".equals(request.getParameter("submit"))) {
			String registerDate = request.getParameter("registerDate");
			String payStatus = request.getParameter("payStatus");
			registerClassBo.insert(memberId, classId, registerDate, payStatus);
			response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-lop");
		} else if ("cancel".equals(request.getParameter("cancel"))) {
			response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-lop");
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/update/cap-nhat-dang-ky-lop.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
