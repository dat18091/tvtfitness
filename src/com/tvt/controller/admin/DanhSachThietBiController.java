package com.tvt.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bean.Equipment;
import com.tvt.model.bo.EquipmentBO;

/**
 * @author HienTT20
 *
 */
@WebServlet(urlPatterns = { "/danh-sach-thiet-bi" })
public class DanhSachThietBiController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EquipmentBO bo = new EquipmentBO();
		int currentPage = 1;
		if (req.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		int rows = bo.numberOfRecord();
		int recordPerPage = 7;
		int start = bo.startPosition(currentPage, recordPerPage);
		int nOfPage = bo.noOfPage(rows, recordPerPage);
		int end = bo.endPosition(rows, start, recordPerPage);
		List<Equipment> equipments = bo.getEquipments(start, recordPerPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/list/danh-sach-thiet-bi.jsp");
		req.setAttribute("list", equipments);
		req.setAttribute("start", start);
		req.setAttribute("end", end);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("noOfPages", nOfPage);
		req.setAttribute("rows", rows);
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
