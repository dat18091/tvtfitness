package com.tvt.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tvt.model.bean.TrainingClass;
import com.tvt.model.bo.TrainingClassBO;

/**
 * Servlet implementation class DanhSachLopTap
 */
@WebServlet("/danh-sach-lop-hoc")
public class DanhSachLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachLopTap() {
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
		
		//Sap xep
		String sort = request.getParameter("sort");
		
		//Tim kiem
		String search = request.getParameter("search");
		
		//Phan trang danh sach
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int recordPerPage = 7;

		TrainingClassBO trainingClassBO = new TrainingClassBO();
		int rows = trainingClassBO.numberOfRecord();
		int nOfPage = trainingClassBO.noOfPage(rows, recordPerPage);
		int start = trainingClassBO.startPosition(currentPage, recordPerPage);
		int end = trainingClassBO.endPosition(rows, start, recordPerPage);
		List<TrainingClass> listClasses = trainingClassBO.getClasses(start, recordPerPage, search, sort);
		request.setAttribute("noOfPages", nOfPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("rows", rows);
		request.setAttribute("listTrainingClass", listClasses);

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/list/danh-sach-lop-hoc.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
