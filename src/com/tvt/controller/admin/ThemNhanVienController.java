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
import com.tvt.model.bean.Employee;
import com.tvt.model.bean.Member;
import com.tvt.model.bo.AccountBO;
import com.tvt.model.bo.BranchBO;
import com.tvt.model.bo.EmployeeBO;
import com.tvt.model.bo.MemberBO;
import com.tvt.utils.MyUtils;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/them-nhan-vien" })
public class ThemNhanVienController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/insert/them-nhan-vien.jsp");
		AccountBO accountBO = new AccountBO();
		try {
			ArrayList<Account> listAccount = accountBO.getListAccount();
			req.setAttribute("listAccount", listAccount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BranchBO branchBO = new BranchBO();
		try {
			ArrayList<Branch> listBranch = branchBO.getListBranch();
			req.setAttribute("listBranch", listBranch);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeBO employeeBO = new EmployeeBO();
		MyUtils myUtils = new MyUtils();

		req.setCharacterEncoding("UTF-8");
		String empId = (String) req.getParameter("empId");
		String empName = (String) req.getParameter("empName");
		String numberPhone = (String) req.getParameter("numberPhone");
		LocalDate birthday = LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String img = (String) req.getParameter("imgUrl");
		String branchId = (String) req.getParameter("branch");
		String accountId = (String) req.getParameter("account");

		Employee employee = new Employee(empId, empName, numberPhone, birthday, img, branchId, accountId);

		if (empId == null || !myUtils.checkValid(empId, "^NV[0-9]{4}$")) {
			System.out.println("ERROR");
		} else {
			try {
				employeeBO.insertEmployee(employee);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		req.setAttribute("employee", employee);

		if ("submit".equals(req.getParameter("submit"))) {
			if (empId != null || myUtils.checkValid(empId, "^NV[0-9]{4}$"))
				resp.sendRedirect(req.getContextPath() + "/danh-sach-nhan-vien");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/insert/them-nhan-vien.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
