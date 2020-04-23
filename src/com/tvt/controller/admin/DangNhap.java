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
 * Servlet implementation class DangNhap
 */
@WebServlet("/login")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhap() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if("Sign In".equals(request.getParameter("submit"))) {
			AccountBO accountBO = new AccountBO();
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			Account getAccount = accountBO.getAccount(userName, password);
			// Check Login
			if (getAccount == null) {
				request.setAttribute("loginFailed", "Tai khoan hoac mat khau khong dung");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			} else {
				// Check account type
				String accountType = getAccount.getAccountType();
				HttpSession session = request.getSession();
				session.setAttribute("thongTinTaiKhoan", getAccount);
				if ("Administrator".equals(accountType)) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/admin-home.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/home-page.jsp");
					dispatcher.forward(request, response);
				}

			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
