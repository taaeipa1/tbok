package org.istqb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.istqb.beans.LOLO;
import org.istqb.idao.ILOLO;

public class LOLODAO implements ILOLO {

	@Override
	public void add(LOLO LOLO, Connection conn) throws Exception {
		String sql = "INSERT INTO LOLO (LO1, LO2, RelatedTo, Createdby, SectionIDPath, SectionPatch) "
				+ "VALUES (?,?,?,?,?,?)";
	
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setInt(1, LOLO.getLo1());
		pStmt.setInt(2, LOLO.getLo2());
		pStmt.setInt(3, LOLO.getRelatedto());
		pStmt.setString(4, LOLO.getCreatedby());
		pStmt.setString(5, LOLO.getSectionidpath());
		pStmt.setString(6, LOLO.getSectionpatch());
		pStmt.execute();
		pStmt.close();

		
	}

	@Override
	public void delete(int aID, Connection conn) throws Exception {
		String sql = "delete from LOLO where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.execute(sql);
		pStmt.close();
	}

	public LOLO edit(int aID, Connection conn) throws Exception {
		String sql = "SELECT Id, Lo1, Lo2, Relatedto, Createdby, Sectionidpath, Sectionpatch from LOLO where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		LOLO lolo;
		if (rS.next()) {
			lolo = new LOLO(rS.getInt("Id"), rS.getInt("lo1"), rS.getInt("lo2"), rS.getInt("Relatedto"), rS.getString("Createdby"), rS.getString("Sectionidpath"), rS.getString("Sectionpatch"));
		} else {
			lolo = new LOLO(0,0,0,0,"User", "Sectionidpath", "Sectionpath");
		}
		rS.close();
		return lolo;
	}
	
	public LOLO edit(LOLO aLOLO, Connection conn) throws Exception {
		if (aLOLO.getId()>0) {
			String sql = "update LOLO "
					+ " set Lo1=" + aLOLO.getLo1() 
					+ " , Lo2=" + aLOLO.getLo2() 
					+ " , Relatedto=" + aLOLO.getRelatedto() 
					+ " , Createdby='"+ aLOLO.getCreatedby() +"'"
					+ " , Sectionidpath='"+ aLOLO.getSectionidpath() +"'"
					+ " , Sectionpatch='"+ aLOLO.getSectionpatch()+"'"
					+ " where id = " + aLOLO.getId();
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
			pStmt.close();
		}
		return aLOLO;
	}
	

	
	@Override
	public List<LOLO> list(Connection conn) throws Exception {

		List<LOLO> list = new ArrayList<>();
		
		//SQL
		String sql = "SELECT Id, LO1, LO2, RelatedTo, CreatedBy, SectionIDPath, SectionPatch from LOLO ";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			list.add(new LOLO(
					rS.getInt("Id"), 
					rS.getInt("LO1"),
					rS.getInt("LO2"),
					rS.getInt("RelatedTo"),
					rS.getString("CreatedBy"), 
					rS.getString("SectionIDPath"), 
					rS.getString("SectionPatch")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;

	}

}
