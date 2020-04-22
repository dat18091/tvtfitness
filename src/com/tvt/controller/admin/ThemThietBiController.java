package com.tvt.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tvt.model.bean.Branch;
import com.tvt.model.bean.Equipment;
import com.tvt.model.bo.BranchBO;
import com.tvt.model.bo.EquipmentBO;

/**
 * @author HienTT20
 *
 */
@WebServlet(urlPatterns = { "/them-thiet-bi" })
@MultipartConfig
public class ThemThietBiController extends HttpServlet {
	List<Branch> branchs = new BranchBO().getAllBranch();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/insert/them-thiet-bi.jsp");
		List<String> brandNames = branchs.stream().map(x -> x.getBranchName()).collect(Collectors.toList());
		req.setAttribute("list", brandNames);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Part filePart = req.getPart("imageUrl");
		String fileName = getSubmittedFileName(filePart);
		InputStream fileContent = filePart.getInputStream();
		File uploads = new File(getServletContext().getInitParameter("file-upload"));
		File file = new File(uploads, fileName);
		Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		EquipmentBO bo= new EquipmentBO();
		
		Equipment equipment= new Equipment();
		equipment.setEquipmentId(req.getParameter("equipmentId"));
		equipment.setEquipmentName(req.getParameter("equipmentName"));
		equipment.setBranchId(getBranchId(req.getParameter("branchName")));
		equipment.setEquipmentType(req.getParameter("equipmentType"));
		equipment.setImportDate(parseString(req.getParameter("importDate")));
		equipment.setWarrantyDate(parseString(req.getParameter("warrantyDate")));
		equipment.setImageUrl(getSubmittedFileName(filePart));
		equipment.setStatus(req.getParameter("status"));
		equipment.setCost(Float.parseFloat(req.getParameter("cost")));
		try {
			bo.insertEquipment(equipment);
			resp.sendRedirect("danh-sach-thiet-bi");
		}catch (Exception e) {
			RequestDispatcher dispatcher= req.getRequestDispatcher("views/admin/insert/them-thiet-bi.jsp");
			req.setAttribute("error", e.getMessage());
			dispatcher.forward(req, resp);
		}
		
	}

	private String getSubmittedFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE
																													// fix.
			}
		}
		return null;
	}
	public String getBranchId(String branchName) {
		for(Branch branch: branchs) {
			if(branch.getBranchName().equals(branchName)) {
				return branch.getBranchId();
			}
			
		}
		return null;
	}
	
	public LocalDate parseString(String date) {
		if(date!=null) {
			return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		return null;
	}

}
