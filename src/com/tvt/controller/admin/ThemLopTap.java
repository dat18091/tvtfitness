package com.tvt.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bo.TrainingClassBO;

/**
 * Servlet implementation class ThemLopTap
 */
@WebServlet("/them-lop-hoc")
public class ThemLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemLopTap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TrainingClassBO trainingClassBO = new TrainingClassBO();
		request.setCharacterEncoding("UTF-8");
		
		if ("submit".equals(request.getParameter("submit"))) {
			String classId = request.getParameter("classId");
			String className = request.getParameter("className");
			String packageId = request.getParameter("packageId");
			String empId = request.getParameter("empId");
			String[] schedule = request.getParameterValues("schedule");//[07:00],[2],[3]
			int maxMember = Integer.parseInt(request.getParameter("maxMember"));
			String dateStart = request.getParameter("dateStart");//yyyy-mm-dd;
			String dateEnd = request.getParameter("dateEnd");
			String branchId = request.getParameter("branchId");
			trainingClassBO.insert(classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd, branchId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/list/danh-sach-lop-hoc.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/insert/them-lop-hoc.jsp");
			dispatcher.forward(request, response);
		}
	}

}
