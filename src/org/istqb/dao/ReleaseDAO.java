package org.istqb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import org.istqb.beans.Release;
import org.istqb.idao.IRelease;

public class ReleaseDAO implements IRelease {

	@Override
	public void add(Release Release, Connection conn) throws Exception {
		String sql = "INSERT INTO SyRelease (Source, Language, Title, Sunset, Sunrise) "
				+ "VALUES (?,?,?,?,?)";
	
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, Release.getSource());
		pStmt.setString(2, Release.getLanguage());
		pStmt.setString(3, Release.getTitle());
		pStmt.setDate(4, Release.getSunset());
		pStmt.setDate(5,  Release.getSunrise());
		pStmt.execute();
		pStmt.close();
		
	}

	@Override
	public void delete(int aID, Connection conn) throws Exception {
		String sql = "delete from SyRelease where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.execute(sql);
		pStmt.close();
		
	}

	public Release edit(int aID, Connection conn) throws Exception {
		String sql = "SELECT ID, Source, Language, Title, Sunset, Sunrise from SyRelease where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		Release release;
		if (rS.next()) {
			release = new Release(rS.getInt("Id"), rS.getString("Source"), rS.getString("Language"), rS.getString("Title"), rS.getDate("Sunset"), rS.getDate("Sunrise"));
		} else {
			Date d = new Date(System.currentTimeMillis());
			release = new Release(0,"Source", "English", "Title", d, d);
		}
		rS.close();
		return release;
	}
	
	public Release edit(Release aRelease, Connection conn) throws Exception {
		if (aRelease.getId()>0) {
			String sql = "update SyRelease "
					+ " set Source='" + aRelease.getSource() +"'"
					+ " , Language='" + aRelease.getLanguage() +"'"
					+ " , Title='" + aRelease.getTitle() +"'"
					+ " , Sunset='" + aRelease.getSunset() +"'"
					+ " , Sunrise='" + aRelease.getSunrise() +"'"
					+ " where id = " + aRelease.getId();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
			pStmt.close();
		}
		return aRelease;
	}

	
	@Override
	public List<Release> list(Connection conn) throws Exception {
		List<Release> list = new ArrayList<>();
		
		//SQL
		String sql = "SELECT ID, Source, Language, Title, Sunset, Sunrise from SyRelease";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			list.add(new Release(
					rS.getInt("Id"), 
					rS.getString("Source"), 
					rS.getString("Language"), 
					rS.getString("Title"),
					rS.getDate("Sunset"),
					rS.getDate("Sunrise")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;	}

}
