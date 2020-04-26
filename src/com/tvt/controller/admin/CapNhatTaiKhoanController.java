package com.tvt.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tvt.model.bean.Account;
import com.tvt.model.bo.AccountBO;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/cap-nhat-tai-khoan" })
public class CapNhatTaiKhoanController extends HttpServlet {

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
		AccountBO bo = new AccountBO();
		Account account = bo.getAccount(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("account", account);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/update/cap-nhat-tai-khoan.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		AccountBO bo = new AccountBO();
		Account account = new Account();
		account.setAccountId(Integer.parseInt(req.getParameter("accountId")));
		account.setAccountName(req.getParameter("accountName"));
		account.setPassword(req.getParameter("password"));
		account.setAccountType(req.getParameter("accountType"));
		try {
			bo.updateAccount(account);
			resp.sendRedirect("danh-sach-tai-khoan");
		} catch (Exception e) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/insert/cap-nhat-tai-khoan.jsp");
			req.setAttribute("error", e.getMessage());
			dispatcher.forward(req, resp);
		}

	}
}
