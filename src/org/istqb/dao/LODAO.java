package org.istqb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.istqb.beans.LO;
import org.istqb.idao.ILO;

public class LODAO implements ILO {

	@Override
	public void add(LO LO, Connection conn) throws Exception {
		String sql = "INSERT INTO LO (ExtID, Topic, Description, Level, Source, RelatedTo, ContentID, SectionIDPath, SectionPath, Createdby, Language) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, LO.getExtid());
		pStmt.setString(2, LO.getTopic());
		pStmt.setString(3, LO.getDescription());
		pStmt.setString(4, LO.getLevel());
		pStmt.setString(5, LO.getSource());
		pStmt.setInt(6, LO.getRelatedto());
		pStmt.setInt(7,  LO.getContentid());
		pStmt.setString(8, LO.getSectionidpath());
		pStmt.setString(9, LO.getSectionpath());
		pStmt.setString(10, LO.getCreatedby());
		pStmt.setString(11, LO.getLanguage());
		pStmt.execute();
		pStmt.close();

		
	}

	@Override
	public void delete(int aID, Connection conn) throws Exception {
		String sql = "delete from LO where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.execute(sql);
		pStmt.close();
		
	}

	public LO edit(int aID, Connection conn) throws Exception {
		String sql = "SELECT Id, Extid, Topic, Description, Level, Source, RelatedTo, ContentID, SectionIDPath, SectionPath, CreatedBy, Language from LO where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		LO lo;
		if (rS.next()) {
			lo = new LO(rS.getInt("Id"), rS.getString("Extid"), rS.getString("Topic"), rS.getString("Description"), rS.getString("Level"), rS.getString("Source"), rS.getInt("RelatedTo"), rS.getInt("ContentID"), rS.getString("SectionIDPath"), rS.getString("SectionPath"), rS.getString("CreatedBy"), rS.getString("Language"));
					
		} else {
			lo = new LO(0,"External ID", "Topic", "Description","Level", "Source", 0, 0, "IDPath", "SectionPath", "CreatedBy", "English");
		}
		rS.close();
		return lo;
	}
	
	public LO edit(LO aLO, Connection conn) throws Exception {
		if (aLO.getId()>0) {
			String sql = "update LO "
					+ " set Extid='" + aLO.getExtid() +"'"
					+ " , Topic='" + aLO.getTopic() +"'"
					+ " , Description='" + aLO.getDescription() +"'"
					+ " , Level='" + aLO.getLevel() +"'"
					+ " , Source='" +  aLO.getSource() +"'"
					+ " , RelatedTo=" + aLO.getRelatedto()
					+ " , ContentID=" + aLO.getContentid()
					+ " , SectionIDPath='" + aLO.getSectionidpath() +"'"
					+ " , SectionPath='" + aLO.getSectionpath() +"'"
					+ " , CreatedBy='" + aLO.getCreatedby() +"'"
					+ " , Language='" + aLO.getLanguage() +"'"
					+ " where id = " + aLO.getId();
			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
			pStmt.close();
		}
		return aLO;
	}

	
	@Override
	public List<LO> list(Connection conn) throws Exception {
		return list("all", conn);  // parameter "all" is not handled ergo all rows will be listed :-)
	}

	/**
	 * @param aParameter unrelated
	 * @param conn
	 * @return List<LO>
	 * @throws Exception
	 */
	
	public List<LO> list(String aParameter, Connection conn) throws Exception {
		List<LO> list = new ArrayList<>();
		String whereclause = "";
		
		if (aParameter.equals("unrelatedLO")) {
			whereclause = " where ";
			whereclause = whereclause + "RelatedTo is null";
		}
		
		
		//SQL
		String sql = "SELECT Id, Extid, Topic, Description, Level, Source, RelatedTo, ContentID, SectionIDPath, SectionPath, CreatedBy, Language from LO";
		sql = sql + whereclause;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			list.add(new LO(rS.getInt("Id"), rS.getString("Extid"), rS.getString("Topic"), rS.getString("Description"), rS.getString("Level"), rS.getString("Source"), rS.getInt("Relatedto"), rS.getInt("Contentid"), rS.getString("Sectionidpath"), rS.getString("Sectionpath"), rS.getString("Createdby"), rS.getString("Language")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;
	}





}



