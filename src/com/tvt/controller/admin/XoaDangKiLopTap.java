package com.tvt.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bo.RegisterClassBo;

/**
 * Servlet implementation class XoaDangKiLopTap
 */
@WebServlet("/xoa-dang-ky-lop-tap")
public class XoaDangKiLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaDangKiLopTap() {
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
		RegisterClassBo registerClassBo = new RegisterClassBo();
		String classId = request.getParameter("classId");
		String memberId = request.getParameter("memberId");
		
		registerClassBo.delete(classId, memberId);
		
		response.sendRedirect(request.getContextPath()+"/danh-sach-dang-ky-lop");
	}

}
