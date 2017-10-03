package org.istqb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.istqb.beans.Glossary;
import org.istqb.idao.IGlossary;

public class GlossaryDAO implements IGlossary {

	@Override
	public void add(Glossary Glossary, Connection conn) throws Exception {
		String sql = "INSERT INTO Glossary (Term, Definition, Area, Letter) "
				+ "VALUES (?,?,?,?)";
	
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, Glossary.getTerm());
		pStmt.setString(2, Glossary.getDefinition());
		pStmt.setString(3, Glossary.getArea());
		pStmt.setString(4, Glossary.getLetter());
		pStmt.execute();
		pStmt.close();
	
	}

	@Override
	public void delete(int aID, Connection conn) throws Exception {
		String sql = "delete from Glossary where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.execute(sql);
		pStmt.close();
	}

	public Glossary edit(int aID, Connection conn) throws Exception {
		String sql = "SELECT Id, Term, Definition, Area, Letter from Glossary where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		Glossary glossary;
		if (rS.next()) {
			glossary = new Glossary(rS.getInt("Id"), rS.getString("Term"), rS.getString("Definition"), rS.getString("Area"), rS.getString("Letter") );
		} else {
			glossary = new Glossary(0,"Term", "Definition", "Area", "Letter");
		}
		rS.close();
		return glossary;
	}
	
	public Glossary edit(Glossary aGlossary, Connection conn) throws Exception {
		if (aGlossary.getId()>0) {
			String sql = "update Glossary "
					+ " set Term='" + aGlossary.getTerm() +"'"
					+ " , Definition='" + aGlossary.getDefinition() +"'"
					+ " , Area='" + aGlossary.getArea() +"'"
					+ " , Letter='" + aGlossary.getLetter() +"'"					
					+ " where id = " + aGlossary.getId();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
			pStmt.close();
		}
		return aGlossary;
	}

	
	@Override
	public List<Glossary> list(Connection conn) throws Exception {
		List<Glossary> list = new ArrayList<>();
		
		//SQL
		String sql = "SELECT Id, Term, Definition, Area, Letter from Glossary";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			list.add(new Glossary(
					rS.getInt("Id"), 
					rS.getString("Term"), 
					rS.getString("Definition"), 
					rS.getString("Area"),
					rS.getString("Letter")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;

	}

}
