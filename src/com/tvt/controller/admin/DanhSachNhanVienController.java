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

import com.tvt.model.bean.Employee;
import com.tvt.model.bo.EmployeeBO;
import com.tvt.model.dao.EmployeeDAO;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/danh-sach-nhan-vien" })
public class DanhSachNhanVienController extends HttpServlet {

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
		List<Employee> list = null;

		String search = req.getParameter("search");
		String sortBy = req.getParameter("sortBy");

		String spageid = req.getParameter("page");
		int pageid = 1;
		int numberRecordPerPage = 5;
		int totalRecord = 0;
		int totalPage = 0;

		if (spageid != null) {
			try {
				pageid = Integer.parseInt(spageid);
			} catch (NumberFormatException e) {
				pageid = 1;
			}
		}

		try {
			totalRecord = new EmployeeDAO().getCount();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		EmployeeBO employeeBO = new EmployeeBO();
		totalPage = totalRecord / numberRecordPerPage;
		int skipRecord = employeeBO.skipRecord(pageid, numberRecordPerPage);
		int numberOfPage = employeeBO.numberOfPage(totalRecord, numberRecordPerPage);
		try {
			list = employeeBO.getAll(skipRecord, numberRecordPerPage, search, sortBy);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		req.setAttribute("total", totalRecord);

		req.setAttribute("page", pageid);

		req.setAttribute("limited", numberRecordPerPage);

		req.setAttribute("listEmployee", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/list/danh-sach-nhan-vien.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
