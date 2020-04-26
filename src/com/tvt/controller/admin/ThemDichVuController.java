package com.tvt.controller.admin;

import java.io.File;
//import java.io.File;
import java.io.IOException;
//import java.util.List;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tvt.model.bean.Service;
import com.tvt.model.bo.ServiceBOImpl;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/them-dich-vu" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ThemDichVuController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private static final String SAVE_DIR = "uploads";
	private static final int UPLOAD_DIRECTORY = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/insert/them-dich-vu.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ServiceBOImpl serviceBOImpl = new ServiceBOImpl();
//		if (ServletFileUpload.isMultipartContent(req)) {
//			try {
//				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
//				for (FileItem item : multiparts) {
//					if (!item.isFormField()) {
//						String name = new File(item.getName()).getName();
//						item.write(new File(req.getServletContext().getContextPath() +File.separator + SAVE_DIR + File.separator + "" + name));
//					}
//				}
//				// File uploaded successfully
//				req.setAttribute("message", "File Uploaded Successfully");
//			} catch (Exception ex) {
//				req.setAttribute("message", "File Upload Failed due to " + ex);
//			}
//		} else {
//			req.setAttribute("message","Sorry this Servlet only handles file upload request");
//		}
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
        			if ("imageUrl".equals(part.getName())) {
        				fileName = new File(getNewFileName(extractFileName(part))).getName();
        				part.write(UPLOAD_DIRECTORY + File.separator + fileName);
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
		float serPrice = 0;
		try {
			serPrice = Float.parseFloat(price);
		} catch (Exception e) {
		}
		Service service = new Service(serviceId, serviceName, serviceType, imageUrl, serPrice);
		try {
			serviceBOImpl.insert(service);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		req.setAttribute("service", service);
		resp.sendRedirect(req.getContextPath() + "/danh-sach-dich-vu");
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
}
