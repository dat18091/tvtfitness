package com.tvt.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bean.TrainingClass;
import com.tvt.model.bo.RegisterClassBo;
import com.tvt.model.bo.TrainingClassBO;

/**
 * Servlet implementation class DangKiLopTap
 */
@WebServlet("/dang-ky-lop-hoc")
public class DangKiLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKiLopTap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		RegisterClassBo registerClassBo = new RegisterClassBo();
		TrainingClassBO trainingClassBO = new TrainingClassBO();
		List<TrainingClass> listClass = trainingClassBO.getAll();
		request.setAttribute("listClass", listClass);

		if ("submit".equals(request.getParameter("submit"))) {
			String memberId = request.getParameter("memberId");
			String classId = request.getParameter("classId");
			String registerDate = request.getParameter("registerDate");
			String payStatus = request.getParameter("payStatus");
			registerClassBo.insert(memberId, classId, registerDate, payStatus);
			response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-lop");
		} else if ("cancel".equals(request.getParameter("cancel"))) {
			response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-lop");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/insert/dang-ky-lop-hoc.jsp");
			dispatcher.forward(request, response);
		}

	}

}
