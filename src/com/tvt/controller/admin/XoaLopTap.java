package com.tvt.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bo.TrainingClassBO;

/**
 * Servlet implementation class XoaLopTap
 */
@WebServlet("/xoa-lop-hoc")
public class XoaLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaLopTap() {
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
		String classId = request.getParameter("classId");
		
		trainingClassBO.deleteById(classId);
		response.sendRedirect(request.getContextPath()+"/danh-sach-lop-hoc");
	}

}
