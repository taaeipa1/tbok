package org.istqb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.istqb.beans.BO;
import org.istqb.idao.IBO;

public class BODAO implements IBO {

	@Override
	public void add(BO BO, Connection conn) throws Exception {
		String sql = "INSERT INTO BO (ExtID, Description, Language) "
					+ "VALUES (?,?,?)";
		
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, BO.getExtid());
		pStmt.setString(2, BO.getDescription());
		pStmt.setString(3, BO.getLanguage());
		pStmt.execute();
		pStmt.close();
		
	}
	
	@Override
	public void delete(int aID, Connection conn) throws Exception {
		String sql = "delete from BO where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.execute(sql);
		pStmt.close();
	}
	
	public BO edit(int aID, Connection conn) throws Exception {
		String sql = "SELECT Id, Extid, Description, Language from BO where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		BO bo;
		if (rS.next()) {
			bo = new BO(rS.getInt("Id"), rS.getString("Extid"), rS.getString("Description"), rS.getString("Language"));
		} else {
			bo = new BO(0,"External ID", "give your description", "English");
		}
		rS.close();
		return bo;
	}
	
	public BO edit(BO aBO, Connection conn) throws Exception {
		if (aBO.getId()>0) {
			String sql = "update BO "
					+ " set ExtID='" + aBO.getExtid() +"'"
					+ " , Description='" + aBO.getDescription() +"'"
					+ " , Language='" + aBO.getLanguage() +"'"
					+ " where id = " + aBO.getId();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
			pStmt.close();
		}
		return aBO;
	}
	
	@Override
	public List<BO> list(Connection conn) throws Exception {

		List<BO> list = new ArrayList<>();
		
		//SQL
		String sql = "SELECT Id, Extid, Description, Language from BO";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			list.add(new BO(
					rS.getInt("Id"), 
					rS.getString("Extid"), 
					rS.getString("Description"), 
					rS.getString("Language")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;
	}

}
