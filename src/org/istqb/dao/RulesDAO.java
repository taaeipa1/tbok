package org.istqb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.istqb.beans.Rules;
import org.istqb.idao.IRules;

public class RulesDAO implements IRules {

	@Override
	public void add(Rules Rules, Connection conn) throws Exception {
		String sql = "INSERT INTO Rules (Area, Rule, Language) "
				+ "VALUES (?,?,?)";
	
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, Rules.getArea());
		pStmt.setString(2, Rules.getRule());
		pStmt.setString(3, Rules.getLanguage());
		pStmt.execute();
		pStmt.close();

		
	}

	@Override
	public void delete(int aID, Connection conn) throws Exception {
		String sql = "delete from Rules where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.execute(sql);
		pStmt.close();
		
	}

	public Rules edit(int aID, Connection conn) throws Exception {
		String sql = "SELECT Id, Area, Rule, Language from Rules where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		Rules rule;
		if (rS.next()) {
			rule = new Rules(rS.getInt("Id"), rS.getString("Area"), rS.getString("Rule"), rS.getString("Language"));
		} else {
			rule = new Rules(0,"Area", "Rule", "English");
		}
		rS.close();
		return rule;
	}
	
	public Rules edit(Rules aRule, Connection conn) throws Exception {
		if (aRule.getId()>0) {
			String sql = "update Rules "
					+ " set Area='" + aRule.getArea() +"'"
					+ " , Rule='" + aRule.getRule() +"'"
					+ " , Language='" + aRule.getLanguage() +"'"
					+ " where id = " + aRule.getId();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
			pStmt.close();
		}
		return aRule;
	}

	
	@Override
	public List<Rules> list(Connection conn) throws Exception {

		List<Rules> list = new ArrayList<>();
		
		//SQL
		String sql = "SELECT Id, Area, Rule, Language from Rules";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			list.add(new Rules(
					rS.getInt("Id"), 
					rS.getString("Area"), 
					rS.getString("Rule"), 
					rS.getString("Language")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;	}

}
