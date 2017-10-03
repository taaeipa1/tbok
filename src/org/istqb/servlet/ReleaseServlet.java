package org.istqb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.istqb.beans.Release;
import org.istqb.bo.ReleaseBO;
import org.istqb.util.ConnectionFactory;

//servlet and controller -- facade to JSP and BackEnd
//@WebServlet("/BO")
@SuppressWarnings("serial")
public class ReleaseServlet extends HttpServlet {
	//doPost for add
	// AddBO.jsp
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Params in Form JSP
		int Id;
		if (req.getParameter("Id").length()==0) {
			Id = 0;
		} else {
			Id = Integer.parseInt(req.getParameter("Id"));	
		}
		String Source = req.getParameter("Source");
		String Language = req.getParameter("Language");
		String Title = req.getParameter("Title");
		String Sunset = req.getParameter("Sunset");
		String Sunrise = req.getParameter("Sunrise");
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.mm.yyyy",Locale.ENGLISH);
		java.sql.Date sunsetDate = java.sql.Date.valueOf(LocalDate.parse(Sunset,format)); 
		java.sql.Date sunriseDate = java.sql.Date.valueOf(LocalDate.parse(Sunrise,format));
		// create object for new BO
		Release Release = new Release(Id, Source, Language, Title, sunsetDate, sunriseDate);
		
		// Connection object
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			if (Release.getId()==0)  {
				ReleaseBO.add(Release, conn);	
				req.setAttribute("mensagem", "Rule has been inserted successfully");
			} else {
				ReleaseBO.edit(Release, conn);
				req.setAttribute("mensagem", "Rule has been updated successfully");
			}
			req.setAttribute("Rule", Release);
			req.setAttribute("tipoMensagem", "alert alert-success");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "Rule insert failed : " + e.getMessage());
		}finally {
			try {
				if (conn!= null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			req.getRequestDispatcher("AddRelease.jsp").forward(req, resp);
		}
		
	}
	
	//doget for list
	//page listBO.jsp
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <Release> listRelease = null;
		Connection conn = null;
		String name;
		String[] values;
		System.out.println("in doGetMethod");
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();

		    Enumeration<String> enum1 = req.getParameterNames();
		    if (enum1.hasMoreElements()) {
		    	for (; enum1.hasMoreElements(); ) {
		    		name = (String)enum1.nextElement();
		    		if (name.equals("edit")) {
		    			System.out.println("edit");
		    			values = req.getParameterValues("edit");
		    			System.out.println(values[0].toString());
		    			Release Release = ReleaseBO.edit(Integer.parseInt(values[0]), conn);
		    			req.setAttribute("Release", Release);
		    			req.getRequestDispatcher("AddRelease.jsp").forward(req, resp);
		    		}
		    		if (name.equals("delete")){
		    			System.out.println("delete");
		    			values = req.getParameterValues("delete");
		    			System.out.println(values[0].toString());
					
		    			ReleaseBO.delete(Integer.parseInt(values[0]), conn);
		    			listRelease = ReleaseBO.list(conn);
		    			req.setAttribute("listRelease", listRelease);
		    			req.getRequestDispatcher("listRelease.jsp").forward(req, resp);
		    		}
		    	}
		    } else {
			    // reload the list
				listRelease = ReleaseBO.list(conn);
				req.setAttribute("listRelease", listRelease);
				req.getRequestDispatcher("listRelease.jsp").forward(req, resp);
		    }
		    	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!= null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			//req.getRequestDispatcher("listBO.jsp").forward(req, resp);
		}
	}
}

