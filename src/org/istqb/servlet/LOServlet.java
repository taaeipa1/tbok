package org.istqb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.istqb.beans.LO;
import org.istqb.bo.LOBO;
import org.istqb.util.ConnectionFactory;

//servlet and controller -- facade to JSP and BackEnd
//@WebServlet("/BO")
@SuppressWarnings("serial")
public class LOServlet extends HttpServlet {
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
		String Extid = req.getParameter("Extid");
		String Topic = req.getParameter("Topic");
		String Description = req.getParameter("Description");
		String Level = req.getParameter("Level");
		String Source = req.getParameter("Source");
		String Relatedto = req.getParameter("Relatedto");
		String Contentid = req.getParameter("Contentid");
		String Sectionidpath = req.getParameter("Sectionidpath");
		String Sectionpath = req.getParameter("Sectionpath");
		String Createdby = req.getParameter("Createdby");
		String Language = req.getParameter("Language");
		
		// create object for new BO
		LO LO = new LO(Id, Extid, Topic, Description, Level, Source, Integer.parseInt(Relatedto), Integer.parseInt(Contentid), Sectionidpath, Sectionpath, Createdby, Language);
		

		// Connection object
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			if (LO.getId()==0)  {
				LOBO.add(LO, conn);	
				req.setAttribute("mensagem", "Learning Objective has been inserted successfully");
			} else {
				LOBO.edit(LO, conn);
				req.setAttribute("mensagem", "Learning Objective has been updated successfully");
			}
			req.setAttribute("LO", LO);
			req.setAttribute("tipoMensagem", "alert alert-success");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "Learning objective - insert failed : " + e.getMessage());
		}finally {
			try {
				if (conn!= null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			req.getRequestDispatcher("AddLO.jsp").forward(req, resp);
		}
		
	}
	
	//doget for list
	//page listBO.jsp
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <LO> listLO = null;
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
		    			LO LO = LOBO.edit(Integer.parseInt(values[0]), conn);
		    			req.setAttribute("LO", LO);
		    			req.getRequestDispatcher("AddLO.jsp").forward(req, resp);
		    		}
		    		if (name.equals("delete")){
		    			System.out.println("delete");
		    			values = req.getParameterValues("delete");
		    			System.out.println(values[0].toString());
					
		    			LOBO.delete(Integer.parseInt(values[0]), conn);
		    			listLO = LOBO.list(conn);
		    			req.setAttribute("listLO", listLO);
		    			req.getRequestDispatcher("listLO.jsp").forward(req, resp);
		    		}
		    	}
		    } else {
			    // reload the list
				listLO = LOBO.list(conn);
				req.setAttribute("listLO", listLO);
				req.getRequestDispatcher("listLO.jsp").forward(req, resp);
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
