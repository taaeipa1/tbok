package org.istqb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.istqb.beans.KA;
import org.istqb.bo.KABO;
import org.istqb.util.ConnectionFactory;

//servlet and controller -- facade to JSP and BackEnd
//@WebServlet("/BO")
@SuppressWarnings("serial")
public class KAServlet extends HttpServlet {
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
		String Knowledgearea = req.getParameter("Knowledgearea");
		
		// create object for new BO
		KA KA = new KA(Id, Knowledgearea);
		
		// Connection object
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			if (KA.getId()==0)  {
				KABO.add(KA, conn);	
				req.setAttribute("mensagem", "KA has been inserted successfully");
			} else {
				KABO.edit(KA, conn);
				req.setAttribute("mensagem", "KA has been updated successfully");
			}
			req.setAttribute("KA", KA);
			req.setAttribute("tipoMensagem", "alert alert-success");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("tipoMensagem", "alert alert-danger");
			req.setAttribute("mensagem", "KA insert failed : " + e.getMessage());
		}finally {
			try {
				if (conn!= null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			req.getRequestDispatcher("AddKA.jsp").forward(req, resp);
		}
		
	}
	
	//doget for list
	//page listBO.jsp
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <KA> listKA = null;
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
		    			KA KA = KABO.edit(Integer.parseInt(values[0]), conn);
		    			req.setAttribute("KA", KA);
		    			req.getRequestDispatcher("AddKA.jsp").forward(req, resp);
		    		}
		    		if (name.equals("delete")){
		    			System.out.println("delete");
		    			values = req.getParameterValues("delete");
		    			System.out.println(values[0].toString());
					
		    			KABO.delete(Integer.parseInt(values[0]), conn);
		    			listKA = KABO.list(conn);
		    			req.setAttribute("listKA", listKA);
		    			req.getRequestDispatcher("listKA.jsp").forward(req, resp);
		    		}
		    	}
		    } else {
			    // reload the list
				listKA = KABO.list(conn);
				req.setAttribute("listKA", listKA);
				req.getRequestDispatcher("listKA.jsp").forward(req, resp);
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

