package com.tvt.controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bo.MemberBO;

/**
 * Servlet implementation class XoaThanhVienServlet
 */
@WebServlet("/xoa-thanh-vien")
public class XoaThanhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoaThanhVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String memberId = (String) request.getParameter("memberId");

		MemberBO memberBO = new MemberBO();

		try {
			memberBO.deleteMember(memberId);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/danh-sach-thanh-vien");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
