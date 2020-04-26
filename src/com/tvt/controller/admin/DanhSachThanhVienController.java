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
import javax.servlet.http.HttpSession;

import com.tvt.model.bean.Member;
import com.tvt.model.bo.MemberBO;
import com.tvt.model.dao.MemberDAO;

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
		HttpSession session = req.getSession();
        if (session.getAttribute("thongTinTaiKhoan") == null) {
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }
		List<Member> list = null;

		String search = req.getParameter("search");
		String sortBy = req.getParameter("sortBy");

		String spageid = req.getParameter("page");
		int pageid = 1;
		int numberRecordPerPage = 5;
		int totalRecord = 0;
		int totalPage = 0;

		if (spageid != null) {
			try {
				pageid = Integer.parseInt(spageid);
			} catch (NumberFormatException e) {
				pageid = 1;
			}
		}

		try {
			totalRecord = new MemberDAO().getCount();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		MemberBO memberBO = new MemberBO();
		totalPage = totalRecord / numberRecordPerPage;
		int skipRecord = memberBO.skipRecord(pageid, numberRecordPerPage);
		int numberOfPage = memberBO.numberOfPage(totalRecord, numberRecordPerPage);
		try {
			list = memberBO.getAll(skipRecord, numberRecordPerPage, search, sortBy);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		req.setAttribute("total", totalRecord);

		req.setAttribute("page", pageid);

		req.setAttribute("limited", numberRecordPerPage);

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
