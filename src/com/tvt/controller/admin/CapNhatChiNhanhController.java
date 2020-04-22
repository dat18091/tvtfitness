package com.tvt.controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bean.Branch;
import com.tvt.model.bo.BranchBO;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/cap-nhat-chi-nhanh" })
public class CapNhatChiNhanhController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BranchBO bo = new BranchBO();
		String id = req.getParameter("id");
		Branch branch = new Branch();
		branch = bo.getBranch(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/update/cap-nhat-chi-nhanh.jsp");
		req.setAttribute("branch", branch);
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BranchBO bo = new BranchBO();
		Branch branch = new Branch();
		branch.setBranchId(req.getParameter("branchId"));
		branch.setBranchName(req.getParameter("branchName"));
		branch.setAddress(req.getParameter("address"));
		try {
			bo.updateBranch(branch);
			resp.sendRedirect("danh-sach-chi-nhanh");
		} catch (SQLException e) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/insert/cap-nhat-chi-nhanh.jsp");
			req.setAttribute("error", e.getMessage());
			dispatcher.forward(req, resp);
		}

	}
}
