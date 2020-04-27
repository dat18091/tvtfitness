package com.tvt.controller.admin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.tvt.model.bean.Account;
import com.tvt.model.bean.Branch;
import com.tvt.model.bean.Employee;
import com.tvt.model.bo.AccountBO;
import com.tvt.model.bo.BranchBO;
import com.tvt.model.bo.EmployeeBO;
import com.tvt.utils.MyUtils;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/them-nhan-vien" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ThemNhanVienController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "D:\\eclipse\\final\\tvtfitness\\WebContent\\resources\\uploads";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
        if (session.getAttribute("thongTinTaiKhoan") == null) {
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/insert/them-nhan-vien.jsp");
		AccountBO accountBO = new AccountBO();
		ArrayList<Account> listAccount = (ArrayList<Account>) accountBO.getAllAccounts();
		req.setAttribute("listAccount", listAccount);

		BranchBO branchBO = new BranchBO();
		ArrayList<Branch> listBranch = (ArrayList<Branch>) branchBO.getAllBranch();
		req.setAttribute("listBranch", listBranch);
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
		LocalDate birthday = LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		String img = (String) req.getParameter("imgUrl");
		// cái ni là input fie vô
		String fileName = "";
		if (ServletFileUpload.isMultipartContent(req)) {
			try {
				Collection<Part> collection = req.getParts();
				for (Part part : collection) {
					if ("imgUrl".equals(part.getName())) {
						fileName = new File(getNewFileName(extractFileName(part))).getName();
						part.write(UPLOAD_DIRECTORY + File.separator + fileName);
						break;
					}
				}
				req.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception e) {
				req.setAttribute("message", "File Upload Failed due to " + e);
			}
		}

		String branchId = (String) req.getParameter("branch");
		String accountId = (String) req.getParameter("account");

		Employee employee = new Employee(empId, empName, numberPhone, birthday, fileName, branchId, accountId);

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

	
	private String getNewFileName(String originalFileName) {
		// TODO Auto-generated method stub
		String[] name = originalFileName.split("\\.");
		StringBuilder sb = new StringBuilder();
		sb.append(name[0]);
		sb.append("_");
		sb.append(System.currentTimeMillis());
		sb.append(".");
		sb.append(name[1]);
		return sb.toString();
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
