package com.tvt.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bean.Account;
import com.tvt.model.bean.Branch;
import com.tvt.model.bean.Member;
import com.tvt.model.bo.AccountBO;
import com.tvt.model.bo.BranchBO;
import com.tvt.model.bo.MemberBO;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/cap-nhat-thanh-vien" })
public class CapNhatThanhVienController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberId = (String) req.getParameter("memberId");

		Member member = null;
		MemberBO memberBO = new MemberBO();
		try {
			member = memberBO.find(memberId);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (member == null) {
			resp.sendRedirect(req.getContextPath() + "/danh-sach-thanh-vien");
			return;
		}

		req.setAttribute("member", member);

		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/update/cap-nhat-thanh-vien.jsp");

		AccountBO accountBO = new AccountBO();
		ArrayList<Account> listAccount = (ArrayList<Account>)accountBO.getAllAccounts();
		req.setAttribute("listAccount", listAccount);

		BranchBO branchBO = new BranchBO();
		ArrayList<Branch> listBranch = (ArrayList<Branch>)branchBO.getAllBranch();
		req.setAttribute("listBranch", listBranch);

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberId = (String) req.getParameter("memberId");
		String fullName = (String) req.getParameter("fullName");
		LocalDate birthday = LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String gender = (String) req.getParameter("sex");
		String numberPhone = (String) req.getParameter("numberPhone");
		String branchId = (String) req.getParameter("branch");
		String accountId = (String) req.getParameter("account");

		Member member = new Member(memberId, fullName, birthday, gender, numberPhone, branchId, accountId);

		MemberBO memberBO = new MemberBO();

		try {
			memberBO.edit(member);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		AccountBO accountBO = new AccountBO();
		ArrayList<Account> listAccount = (ArrayList<Account>)accountBO.getAllAccounts();
		req.setAttribute("listAccount", listAccount);

		BranchBO branchBO = new BranchBO();
		ArrayList<Branch> listBranch = (ArrayList<Branch>)branchBO.getAllBranch();
		req.setAttribute("listBranch", listBranch);

		req.setAttribute("member", member);

		if ("submit".equals(req.getParameter("submit"))) {
			resp.sendRedirect(req.getContextPath() + "/danh-sach-thanh-vien");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/update/cap-nhat-thanh-vien.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
