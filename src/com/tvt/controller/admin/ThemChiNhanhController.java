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
@WebServlet(urlPatterns = { "/them-chi-nhanh" })
public class ThemChiNhanhController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/insert/them-chi-nhanh.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		BranchBO bo = new BranchBO();

		Branch branch = new Branch();
		branch.setBranchId(req.getParameter("brandId"));
		branch.setBranchName(req.getParameter("branchName"));
		branch.setAddress(req.getParameter("address"));
		try {
			bo.insertBrand(branch);
			resp.sendRedirect("danh-sach-chi-nhanh");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/insert/them-chi-nhanh.jsp");
			req.setAttribute("error", e.getMessage());
			dispatcher.forward(req, resp);
		}

	}

}
