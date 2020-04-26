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
import javax.servlet.http.HttpSession;

import com.tvt.model.bean.Account;
import com.tvt.model.bean.Branch;
import com.tvt.model.bean.Member;
import com.tvt.model.bo.AccountBO;
import com.tvt.model.bo.BranchBO;
import com.tvt.model.bo.MemberBO;
import com.tvt.utils.MyUtils;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/them-thanh-vien" })
public class ThemThanhVienController extends HttpServlet {

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
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/insert/them-thanh-vien.jsp");
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
		// TODO Auto-generated method stub
		MemberBO memberBO = new MemberBO();
		MyUtils myUtils = new MyUtils();

		req.setCharacterEncoding("UTF-8");
		String memberId = (String) req.getParameter("memberId");
		String fullName = (String) req.getParameter("fullName");
		LocalDate birthday = LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String gender = (String) req.getParameter("sex");
		String numberPhone = (String) req.getParameter("numberPhone");
		String branchId = (String) req.getParameter("branch");
		String accountId = (String) req.getParameter("account");

		Member member = new Member(memberId, fullName, birthday, gender, numberPhone, branchId, accountId);

		if (memberId == null || !myUtils.checkValid(memberId, "^TV[0-9]{5}$")) {
			System.out.println("ERROR");

		} else {
			try {
				memberBO.insertMember(member);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		req.setAttribute("member", member);

		if ("submit".equals(req.getParameter("submit"))) {
			if (memberId != null || myUtils.checkValid(memberId, "^TV[0-9]{5}$"))
				resp.sendRedirect(req.getContextPath() + "/danh-sach-thanh-vien");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/insert/them-thanh-vien.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
