package org.istqb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.istqb.beans.Domain;
import org.istqb.idao.IDomain;

public class DomainDAO implements IDomain {

	@Override
	public void add(Domain Domain, Connection conn) throws Exception {
		String sql = "INSERT INTO Domain (Domain, Value, Language) "
				+ "VALUES (?,?,?)";
	
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, Domain.getDomain());
		pStmt.setString(2, Domain.getValue());
		pStmt.setString(3, Domain.getLanguage());
		pStmt.execute();
		pStmt.close();
	}

	@Override
	public void delete(int aID, Connection conn) throws Exception {
		String sql = "delete from Domain where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.execute(sql);
		pStmt.close();
	}

	public Domain edit(int aID, Connection conn) throws Exception {
		String sql = "SELECT Id, Domain, Value, Language from Domain where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		Domain domain;
		if (rS.next()) {
			domain = new Domain(rS.getInt("Id"), rS.getString("Domain"), rS.getString("Value"), rS.getString("Language"));
		} else {
			domain = new Domain(0,"Domain-Name", "Domain-Value", "English");
		}
		rS.close();
		return domain;
	}
	
	public Domain edit(Domain aDomain, Connection conn) throws Exception {
		if (aDomain.getId()>0) {
			String sql = "update Domain "
					+ " set Domain='" + aDomain.getDomain()+"'"
					+ " , Value='" + aDomain.getValue() +"'"
					+ " , Language='" + aDomain.getLanguage() +"'"
					+ " where id = " + aDomain.getId();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
			pStmt.close();
		}
		return aDomain;
	}

	
	@Override
	public List<Domain> list(Connection conn) throws Exception {
		List<Domain> list = new ArrayList<>();
		
		//SQL
		String sql = "SELECT Id, Domain, Value, Language from Domain";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			list.add(new Domain(
					rS.getInt("Id"), 
					rS.getString("Domain"), 
					rS.getString("Value"), 
					rS.getString("Language")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;

	}

	public List<Domain> list(String dName, Connection conn) throws Exception {
		List<Domain> list = new ArrayList<>();
		
		//SQL
		String sql = "SELECT Id, Domain, Value, Language from Domain where Domain = '" + dName +"'";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			list.add(new Domain(
					rS.getInt("Id"), 
					rS.getString("Domain"), 
					rS.getString("Value"), 
					rS.getString("Language")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;

	}

	
}
