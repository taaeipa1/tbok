package org.istqb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.istqb.beans.BO;
import org.istqb.bo.BOBO;
import org.istqb.util.ConnectionFactory;

//servlet and controller -- facade to JSP and BackEnd
//@WebServlet("/BO")
@SuppressWarnings("serial")
public class BOServlet extends HttpServlet {
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
		String Description = req.getParameter("Description");
		String Language = req.getParameter("Language");
		
		// create object for new BO
		BO BO = new BO(Id, ExtID, Description, Language);
		
		// Connection object
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			if (BO.getId()==0)  {
				BOBO.add(BO, conn);	
				req.setAttribute("mensagem", "BO has been inserted successfully");
			} else {
				BOBO.edit(BO, conn);
				req.setAttribute("mensagem", "BO has been updated successfully");
			}
			req.setAttribute("BO", BO);
			req.setAttribute("tipoMensagem", "alert alert-success");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "BO insert failed : " + e.getMessage());
		}finally {
			try {
				if (conn!= null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			req.getRequestDispatcher("AddBO.jsp").forward(req, resp);
		}
		
	}
	
	//doget for list
	//page listBO.jsp
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <BO> listBO = null;
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
		    			BO BO = BOBO.edit(Integer.parseInt(values[0]), conn);
		    			req.setAttribute("BO", BO);
		    			req.getRequestDispatcher("AddBO.jsp").forward(req, resp);
		    		}
		    		if (name.equals("delete")){
		    			System.out.println("delete");
		    			values = req.getParameterValues("delete");
		    			System.out.println(values[0].toString());
					
		    			BOBO.delete(Integer.parseInt(values[0]), conn);
		    			listBO = BOBO.list(conn);
		    			req.setAttribute("listBO", listBO);
		    			req.getRequestDispatcher("listBO.jsp").forward(req, resp);
		    		}
		    	}
		    } else {
			    // reload the list
				listBO = BOBO.list(conn);
				req.setAttribute("listBO", listBO);
				req.getRequestDispatcher("listBO.jsp").forward(req, resp);
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

