package com.tvt.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tvt.model.bean.Service;
import com.tvt.model.bo.ServiceBOImpl;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/cap-nhat-dich-vu" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CapNhatDichVuController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "D:\\eclipse\\final\\tvtfitness\\WebContent\\resources\\uploads";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceBOImpl serviceBOImpl = new ServiceBOImpl();

		String serviceId = (String) req.getParameter("serviceId");

		Service service = null;
		try {
			service = serviceBOImpl.searchById(serviceId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (service == null) {
			resp.sendRedirect(req.getContextPath() + "/danh-sach-dich-vu");
			return;
		}
		req.setAttribute("service", service);
		RequestDispatcher dispatcher = req.getServletContext()
				.getRequestDispatcher("/views/admin/update/cap-nhat-dich-vu.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceBOImpl serviceBOImpl = new ServiceBOImpl();

		req.setCharacterEncoding("UTF-8");
		String serviceId = (String) req.getParameter("serviceId");
		String serviceName = (String) req.getParameter("serviceName");
		String serviceType = "";
		String[] type = req.getParameterValues("serviceType");
		for (int i = 0; i < type.length; i++) {
			serviceType += type[i];
		}
		String imageUrl = (String) req.getParameter("imageUrl");

		String fileName = "";
		if(ServletFileUpload.isMultipartContent(req)){
            try {
                Collection<Part> collection = req.getParts();
        		for (Part part : collection) {
        			if ("imgUrl".equals(part.getName())) {
        				fileName = new File(getNewFileName((String) extractFileName(part))).getName();
        				part.write(SAVE_DIRECTORY + File.separator + fileName);
        				break;
        			}
        		}
            
               //File uploaded successfully
               req.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               req.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
            req.setAttribute("message", "Sorry this Servlet only handles file upload request");
        }
		String price = req.getParameter("price");
		float sprice = 0;
		try {
			sprice = Float.parseFloat(price);
		} catch (Exception e) {
		}
		Service service = null;
		try {
			service = new Service(serviceId, serviceName, serviceType, imageUrl, sprice);
			serviceBOImpl.update(service);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		req.setAttribute("service", service);
		resp.sendRedirect(req.getContextPath() + "/danh-sach-dich-vu");
	}

	private String getNewFileName(String originalFileName) {
		String[] name = originalFileName.split("\\.");
        StringBuilder sb = new StringBuilder();
        sb.append(name[0]);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append(".");
        sb.append(name[1]);
        return sb.toString();
	}

	private Object extractFileName(Part part) {
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