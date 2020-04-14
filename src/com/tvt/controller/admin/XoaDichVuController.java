package com.tvt.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tvt.model.bo.ServiceBOImpl;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = {"/xoa-dich-vu"})
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
//maxFileSize = 1024 * 1024 * 50, // 50MB
//maxRequestSize = 1024 * 1024 * 50) // 50MB
// fileSizeThreshold:  Nếu kích thước file upload lơn hơn threshold sẽ được ghi trực tiếp vào ổ đĩa thay vì lưu ở memory đệm.
public class XoaDichVuController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serviceId = (String) req.getParameter("serviceId");
		ServiceBOImpl serviceBOImpl = new ServiceBOImpl();
		serviceBOImpl.delete(serviceId);
		resp.sendRedirect(req.getContextPath() + "/danh-sach-dich-vu");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
