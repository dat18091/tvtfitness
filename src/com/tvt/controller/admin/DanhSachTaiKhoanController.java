package com.tvt.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bean.Account;
import com.tvt.model.bo.AccountBO;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/danh-sach-tai-khoan" })
public class DanhSachTaiKhoanController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountBO bo = new AccountBO();
		int currentPage = 1;
		if(req.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		int rows = bo.numberOfRecord();
		int recordPerPage = 7;
		int start = bo.startPosition(currentPage, recordPerPage);
		int nOfPage= bo.noOfPage(rows, recordPerPage);
		int end = bo.endPosition(rows, start, recordPerPage);
		List<Account> accounts = bo.getAccounts(start, recordPerPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/list/danh-sach-tai-khoan.jsp");
		req.setAttribute("list", accounts);
		req.setAttribute("start", start);
		req.setAttribute("end", end);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("noOfPages", nOfPage);
		req.setAttribute("rows", rows);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
