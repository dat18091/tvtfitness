package com.tvt.controller.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bean.Branch;
import com.tvt.model.bean.Equipment;
import com.tvt.model.bo.BranchBO;
import com.tvt.model.bo.EquipmentBO;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/cap-nhat-thiet-bi" })
public class CapNhatThietBiController extends HttpServlet {

	List<Branch> branchs = new BranchBO().getAllBranch();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EquipmentBO bo = new EquipmentBO();
		String equipmentId = req.getParameter("id");
		Equipment equipment = bo.getEquipment(equipmentId);
		String branchName = bo.getBranchName(equipment.getBranchId());
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/update/cap-nhat-thiet-bi.jsp");
		req.setAttribute("equipment", equipment);
		req.setAttribute("branchName", branchName);
		req.setAttribute("list", new BranchBO().getBranchNames());
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		EquipmentBO bo = new EquipmentBO();
		Equipment equipment = new Equipment();
		equipment.setEquipmentId(req.getParameter("equipmentId"));
		equipment.setEquipmentName(req.getParameter("equipmentName"));
		equipment.setEquipmentType(req.getParameter("equipmentType"));
		equipment.setImportDate(parseString(req.getParameter("importDate")));
		equipment.setWarrantyDate(parseString(req.getParameter("warrantyDate")));
		equipment.setStatus(req.getParameter("status"));
		equipment.setCost(Float.parseFloat(req.getParameter("cost")));
		equipment.setBranchId(getBranchId(req.getParameter("branchName")));
		try {
			bo.updateEquipment(equipment);
			resp.sendRedirect("danh-sach-thiet-bi");
		} catch (Exception e) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/insert/them-thiet-bi.jsp");
			req.setAttribute("error", e.getMessage());
			dispatcher.forward(req, resp);
		}
	}

	public String getBranchId(String branchName) {
		for (Branch branch : branchs) {
			if (branch.getBranchName().equals(branchName)) {
				return branch.getBranchId();
			}

		}
		return null;
	}

	public LocalDate parseString(String date) {
		if (date != null) {
			return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		return null;
	}

}
