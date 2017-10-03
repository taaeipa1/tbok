package org.istqb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.istqb.beans.Glossary;
import org.istqb.bo.GlossaryBO;
import org.istqb.util.ConnectionFactory;

//servlet and controller -- facade to JSP and BackEnd
//@WebServlet("/BO")
@SuppressWarnings("serial")
public class GlossaryServlet extends HttpServlet {
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
		String Term = req.getParameter("Term");
		String Definition = req.getParameter("Definition");
		String Area = req.getParameter("Area");
		String Letter = req.getParameter("Letter");
		
		// create object for new BO
		Glossary Glossary = new Glossary(Id, Term, Definition, Area, Letter);
		
		// Connection object
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			if (Glossary.getId()==0)  {
				GlossaryBO.add(Glossary, conn);	
				req.setAttribute("mensagem", "BO has been inserted successfully");
			} else {
				GlossaryBO.edit(Glossary, conn);
				req.setAttribute("mensagem", "BO has been updated successfully");
			}
			req.setAttribute("Glossary", Glossary);
			req.setAttribute("tipoMensagem", "alert alert-success");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "Glossary insert failed : " + e.getMessage());
		}finally {
			try {
				if (conn!= null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			req.getRequestDispatcher("AddGlossary.jsp").forward(req, resp);
		}
		
	}
	
	//doget for list
	//page listBO.jsp
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <Glossary> listGlossary = null;
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
		    			Glossary Glossary = GlossaryBO.edit(Integer.parseInt(values[0]), conn);
		    			req.setAttribute("Glossary", Glossary);
		    			req.getRequestDispatcher("AddGlossary.jsp").forward(req, resp);
		    		}
		    		if (name.equals("delete")){
		    			System.out.println("delete");
		    			values = req.getParameterValues("delete");
		    			System.out.println(values[0].toString());
					
		    			GlossaryBO.delete(Integer.parseInt(values[0]), conn);
		    			listGlossary = GlossaryBO.list(conn);
		    			req.setAttribute("listGlossary", listGlossary);
		    			req.getRequestDispatcher("listGlossary.jsp").forward(req, resp);
		    		}
		    	}
		    } else {
			    // reload the list
				listGlossary = GlossaryBO.list(conn);
				req.setAttribute("listGlossary", listGlossary);
				req.getRequestDispatcher("listGlossary.jsp").forward(req, resp);
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
