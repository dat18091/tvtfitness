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
import com.tvt.model.bean.Employee;
import com.tvt.model.bean.Package;
import com.tvt.model.bean.TrainingClass;
import com.tvt.model.bo.BranchBO;
import com.tvt.model.bo.EmployeeBO;
import com.tvt.model.bo.PackageBO;
import com.tvt.model.bo.TrainingClassBO;

/**
 * Servlet implementation class CapNhatLopTap
 */
@WebServlet("/cap-nhat-lop-hoc")
public class CapNhatLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapNhatLopTap() {
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

		String classId = request.getParameter("classId");
		TrainingClass trainingClass = trainingClassBO.searchById(classId);
		request.setAttribute("lopTap", trainingClass);

		if ("submit".equals(request.getParameter("submit"))) {
			String className = request.getParameter("className");
			String packageId = request.getParameter("packageId");
			String empId = request.getParameter("empId");
			String[] schedule = request.getParameterValues("schedule");// [07:00],[2],[3]
			int maxMember = Integer.parseInt(request.getParameter("maxMember"));
			String dateStart = request.getParameter("dateStart");// yyyy-mm-dd;
			String dateEnd = request.getParameter("dateEnd");
			String status = request.getParameter("status");
			String branchId = request.getParameter("branchId");
			trainingClassBO.update(classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd,status,
					branchId);
			response.sendRedirect(request.getContextPath() + "/danh-sach-lop-hoc");
		} else if ("cancel".equals(request.getParameter("cancel"))) {
			response.sendRedirect(request.getContextPath()+"/danh-sach-lop-tap");
		} else {
			request.setAttribute("classId", classId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/update/cap-nhat-lop-hoc.jsp");
			dispatcher.forward(request, response);
		}
	}

}
