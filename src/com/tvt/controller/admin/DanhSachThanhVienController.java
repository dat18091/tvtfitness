package com.tvt.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bean.Member;
import com.tvt.model.bo.MemberBO;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/danh-sach-thanh-vien" })
public class DanhSachThanhVienController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Member> list = null;
		try {
			MemberBO memberBO = new MemberBO();
			list = memberBO.getAll();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		req.setAttribute("listMember", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/list/danh-sach-thanh-vien.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
