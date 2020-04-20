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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TrainingClassBO trainingClassBO = new TrainingClassBO();
		List<TrainingClass> listClasses = trainingClassBO.getAll();
		
		request.setAttribute("listTrainingClass", listClasses);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/list/danh-sach-lop-hoc.jsp");
		dispatcher.forward(request, response);
	}

}
