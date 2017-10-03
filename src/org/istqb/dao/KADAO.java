package org.istqb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.istqb.beans.KA;
import org.istqb.idao.IKA;

public class KADAO implements IKA {

	@Override
	public void add(KA KA, Connection conn) throws Exception {
		String sql = "INSERT INTO KA (KnowledgeArea) "
				+ "VALUES (?,?,?)";
	
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, KA.getKnowledgearea());
		pStmt.execute();
		pStmt.close();
	}

	@Override
	public void delete(int aID, Connection conn) throws Exception {
		String sql = "delete from KA where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.execute(sql);
		pStmt.close();
	}

	public KA edit(int aID, Connection conn) throws Exception {
		String sql = "SELECT Id, Knowledgearea from KA where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		KA ka;
		if (rS.next()) {
			ka = new KA(rS.getInt("Id"), rS.getString("Knowledgearea"));
		} else {
			ka = new KA(0,"KnowledgeArea");
		}
		rS.close();
		return ka;
	}
	
	public KA edit(KA aKA, Connection conn) throws Exception {
		if (aKA.getId()>0) {
			String sql = "update KA "
					+ " set Knowledgearea='" + aKA.getKnowledgearea() +"'"
					+ " where id = " + aKA.getId();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
			pStmt.close();
		}
		return aKA;
	}

	
	@Override
	public List<KA> list(Connection conn) throws Exception {
		List<KA> list = new ArrayList<>();
		
		//SQL
		String sql = "SELECT Id, Knowledgearea from KA";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			list.add(new KA(
					rS.getInt("Id"), 
					rS.getString("Knowledgearea")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;

	}

}
