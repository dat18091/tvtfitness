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

import com.tvt.model.bean.Branch;
import com.tvt.model.bo.BranchBO;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/danh-sach-chi-nhanh" })
public class DanhSachChiNhanhController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int curentPage = 1;
			if (req.getParameter("currentPage") != null) {
				curentPage = Integer.parseInt(req.getParameter("currentPage"));
			}
			int recordPerPage = 7;
			BranchBO bo = new BranchBO();
			int rows = bo.numberOfRecord();
			int nOfPage = rows / recordPerPage;
			int start = curentPage*recordPerPage-recordPerPage;
			if (rows % recordPerPage > 0) {
				nOfPage++;
			}
			int end = start+recordPerPage+1;
			if( end > rows) {
				end=rows;
			}
			List<Branch> branchs = bo.getBranchs(start, recordPerPage);
			req.setAttribute("noOfPages", nOfPage);
			req.setAttribute("currentPage", curentPage);
			req.setAttribute("list", branchs);
			req.setAttribute("start", start);
			req.setAttribute("end", end);
			req.setAttribute("rows", rows);		
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/list/danh-sach-chi-nhanh.jsp");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
