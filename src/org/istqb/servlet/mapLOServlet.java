package org.istqb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.istqb.beans.Domain;
import org.istqb.beans.LO;
import org.istqb.bo.DomainBO;
import org.istqb.bo.JSONAdapter;
import org.istqb.bo.LOBO;
import org.istqb.util.ConnectionFactory;
import org.json.JSONArray;
import org.json.JSONException;

//servlet and controller -- facade to JSP and BackEnd
//@WebServlet("/BO")
@SuppressWarnings("serial")
public class mapLOServlet extends HttpServlet {
	//doPost for add
	// AddBO.jsp
	//private JSONAdapter mapLO;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Params in Form JSP
				
		System.out.println("in doPostMethod - get the mapping");
		System.out.println(req.getParameter("mapping"));
		JSONAdapter mapLO = new JSONAdapter();
		mapLO.setJsonObjectString(req.getParameter("mapping"));


		try {
			JSONArray x = new JSONArray(mapLO.getJsonObjectString());
			JSONArray y = new JSONArray();
			JSONArray a = new JSONArray();
			
			for (int j=0;j<x.length();j++){
				y = x.getJSONArray(j);
				int z = y.getInt(2);
				if (z>0){
					a.put(y);
					// y.getInt(0); --> das ist der Key --> if LO is related then set RelatedTo = 1
					int i = Integer.parseInt(y.getString(0));
					LO lo = LOBO.edit(i, ConnectionFactory.getInstance().getConnection());
					if (lo.getRelatedto()==1){
						// do nothing
					} else {
						lo.setRelatedto(1);
						LOBO.edit(lo, ConnectionFactory.getInstance().getConnection());						
					}
				}
			}
			System.out.println(a.toString());
			mapLO.setJsonObjectString(a.toString());
			Domain dom = DomainBO.edit(1, ConnectionFactory.getInstance().getConnection());
			dom.setValue(a.toString());
			DomainBO.edit(dom, ConnectionFactory.getInstance().getConnection());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("mapping", mapLO);
		
		List <LO> listLO = null;
		List <LO> listLOAll = null;
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			listLO = LOBO.list("unrelatedLO", conn);
			req.setAttribute("listLO", listLO);
			listLOAll = LOBO.list(conn);
			req.setAttribute("listLOAll", listLOAll);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// create a json array
		req.getRequestDispatcher("mapLO.jsp").forward(req, resp);
	}
	
	//doget for list
	//page listBO.jsp
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("in doGetMethod");
		// create object for new BO
		System.out.println("initialize JSONAdapter");
		JSONAdapter mapLO = new JSONAdapter();
	
		System.out.println(mapLO.getJsonObjectString());
		req.setAttribute("mapping", mapLO);
//		req.setAttribute("mappingTable", "[['d6', 0, 1, 'green', 'B1'], ['d6', 6, 2, 'green', 'B2'], ['d7', 6, 3, 'green', 'B3']]");

		
		List <LO> listLO = null;
		List <LO> listLOAll = null;
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			listLO = LOBO.list("unrelatedLO", conn);
			req.setAttribute("listLO", listLO);
			listLOAll = LOBO.list(conn);
			req.setAttribute("listLOAll", listLOAll);
			
			
			List<Domain> d = DomainBO.list("LOMapping", conn);
			for (int i = 0 ; i < d.size(); i++) {
				Domain domain = (Domain) d.get(i);
				mapLO.setJsonObjectString(domain.getValue());
			}
			req.setAttribute("mapping", mapLO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("mapLO.jsp").forward(req, resp);
	
	}
		
}
