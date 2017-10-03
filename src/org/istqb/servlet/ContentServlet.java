package org.istqb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.istqb.beans.Content;
import org.istqb.bo.ContentBO;
import org.istqb.util.ConnectionFactory;

//servlet and controller -- facade to JSP and BackEnd
//@WebServlet("/BO")
@SuppressWarnings("serial")
public class ContentServlet extends HttpServlet {
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
		String ExtID = req.getParameter("Extid");
		String Chapter = req.getParameter("Chapter");
		String KLevel = req.getParameter("KLevel");
		String Contentb = req.getParameter("Content");
		String Source = req.getParameter("Source");
		String Language = req.getParameter("Language");
		int Time = 0;
		// create object for new BO
		Content Content = new Content(Id, ExtID, Chapter, KLevel, Contentb, Source, Time, 0, 0, "SectionIDPath", "SectionPath", "CreatedBy", Language);
		
		// Connection object
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			if (Content.getId()==0)  {
				ContentBO.add(Content, conn);	
				req.setAttribute("mensagem", "Content has been inserted successfully");
			} else {
				ContentBO.edit(Content, conn);
				req.setAttribute("mensagem", "Content has been updated successfully");
			}
			req.setAttribute("Content", Content);
			req.setAttribute("tipoMensagem", "alert alert-success");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "Content insert failed : " + e.getMessage());
		}finally {
			try {
				if (conn!= null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			req.getRequestDispatcher("AddContent.jsp").forward(req, resp);
		}
		
	}
	
	//doget for list
	//page listBO.jsp
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <Content> listContent = null;
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
		    			Content Content = ContentBO.edit(Integer.parseInt(values[0]), conn);
		    			req.setAttribute("Content", Content);
		    			req.getRequestDispatcher("AddContent.jsp").forward(req, resp);
		    		}
		    		if (name.equals("delete")){
		    			System.out.println("delete");
		    			values = req.getParameterValues("delete");
		    			System.out.println(values[0].toString());
					
		    			ContentBO.delete(Integer.parseInt(values[0]), conn);
		    			listContent = ContentBO.list(conn);
		    			req.setAttribute("listContent", listContent);
		    			req.getRequestDispatcher("listContent.jsp").forward(req, resp);
		    		}
		    	}
		    } else {
			    // reload the list
				listContent = ContentBO.list(conn);
				req.setAttribute("listContent", listContent);
				req.getRequestDispatcher("listContent.jsp").forward(req, resp);
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

