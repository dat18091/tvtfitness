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
		TrainingClassBO trainingClassBO = new TrainingClassBO();
		if ("submit".equals(request.getParameter("submit"))) {
			String classId = request.getParameter("classId");
			String className = request.getParameter("className");
			String packageName = request.getParameter("packageName");
			String memberName = request.getParameter("memberName");
			String timeTable = request.getParameter("timeTable");
			String maxMember = request.getParameter("maxMember");
			String timeStart = request.getParameter("timeStart");
			String timeEnd = request.getParameter("timeEnd");
			trainingClassBO.themLopTap(classId, className, packageName, memberName, timeTable, maxMember, timeStart,
					timeEnd);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/insert/them-lop-hoc.jsp");
		dispatcher.forward(request, response);
	}

}
