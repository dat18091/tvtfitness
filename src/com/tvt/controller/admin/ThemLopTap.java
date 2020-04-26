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

import com.tvt.model.bean.Branch;
import com.tvt.model.bean.Employee;
import com.tvt.model.bean.Package;
import com.tvt.model.bean.TrainingClass;
import com.tvt.model.bo.BranchBO;
import com.tvt.model.bo.EmployeeBO;
import com.tvt.model.bo.PackageBO;
import com.tvt.model.bo.TrainingClassBO;

/**
 * Servlet implementation class ThemLopTap
 */
@WebServlet("/them-lop-hoc")
public class ThemLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemLopTap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiem tra da dang nhap chua
		HttpSession session = request.getSession();
		if (session.getAttribute("thongTinTaiKhoan") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		request.setCharacterEncoding("UTF-8");

		TrainingClassBO trainingClassBO = new TrainingClassBO();

		BranchBO branchBO = new BranchBO();
		PackageBO packageBO = new PackageBO();
		EmployeeBO employeeBO = new EmployeeBO();
		
		// Danh sach cac goi, nhan vien va chi nhanh.
		List<Branch> listBranchs = null;
		List<Package> listPackage = null;
		List<Employee> listEmployee = null;

		try {
			listBranchs = branchBO.getAllBranch();
			listPackage = packageBO.getAll();
			listEmployee = employeeBO.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listBranch", listBranchs);
		request.setAttribute("listGoi", listPackage);
		request.setAttribute("listEmp", listEmployee);
		
		if ("submit".equals(request.getParameter("submit"))) {
			String classId = request.getParameter("classId");
			TrainingClass trainingClass =  trainingClassBO.searchById(classId);
			if (trainingClass != null) {
				request.setAttribute("error", "Mã lớp đã tồn tại mời nhập mã khác");
				RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/insert/them-lop-hoc.jsp");
				dispatcher.forward(request, response);
			}
			String className = request.getParameter("className");
			String packageId = request.getParameter("packageId");
			String empId = request.getParameter("empId");
			String[] schedule = request.getParameterValues("schedule");// [07:00],[2],[3]
			int maxMember = Integer.parseInt(request.getParameter("maxMember"));
			String dateStart = request.getParameter("dateStart");// yyyy-mm-dd;
			String dateEnd = request.getParameter("dateEnd");
			String branchId = request.getParameter("branchId");
			String status = "Lớp mới tạo";
			trainingClassBO.insert(classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd,status,
					branchId);
			response.sendRedirect(request.getContextPath() + "/danh-sach-lop-hoc");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/insert/them-lop-hoc.jsp");
			dispatcher.forward(request, response);
		}
	}

}
