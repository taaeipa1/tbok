package org.istqb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.istqb.beans.Content;
import org.istqb.idao.IContent;

public class ContentDAO implements IContent {

	@Override
	public void add(Content Content, Connection conn) throws Exception {
		String sql = "INSERT INTO Content (ExtID, Chapter, Content, CreatedBy, KLevel, Language, Source, LOID, RelatedTo, SectionIDPath, SectionPath) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, Content.getExtid());
		pStmt.setString(2, Content.getChapter());
		pStmt.setString(3, Content.getContent());
		pStmt.setString(4, Content.getCreatedby());
		pStmt.setString(5, Content.getKlevel());
		pStmt.setString(6, Content.getLanguage());
		pStmt.setString(7, Content.getSource());
		pStmt.setInt(8, Content.getLoid());
		pStmt.setInt(9, Content.getRelatedto());
		pStmt.setString(10, Content.getSectionidpath());
		pStmt.setString(11, Content.getSectionpath());
		pStmt.execute();
		pStmt.close();
		
	}

	@Override
	public void delete(int aID, Connection conn) throws Exception {
		String sql = "delete from Content where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.execute(sql);
		pStmt.close();
		
	}

	public Content edit(int aID, Connection conn) throws Exception {
		String sql = "SELECT Id, Extid, Chapter, Content, CreatedBy, KLevel, Language, Source, Time, RelatedTo, LOID, SectionIDPath, SectionPath from Content where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		Content content;
		if (rS.next()) {
			content = new Content(rS.getInt("Id"), rS.getString("Extid"), rS.getString("Chapter"),
					rS.getString("KLevel"),
					rS.getString("Content"),
					rS.getString("Source"),
					rS.getInt("Time"),
					rS.getInt("RelatedTo"),
					rS.getInt("LOID"),
					rS.getString("SectionIDPath"),
					rS.getString("SectionPath"),
					rS.getString("CreatedBy"),
					rS.getString("Language"));
		} else {
			content = new Content(0,"External ID", "Chapter", "","Content","Source", 0,0,0,"","","","");
		}
		rS.close();
		return content;
	}
	
	public Content edit(Content aContent, Connection conn) throws Exception {
		if (aContent.getId()>0) {
			String sql = "update Content "
					+ " set ExtID='" + aContent.getExtid() +"'"
					+ " , Chapter='" + aContent.getChapter() +"'"
					+ " , KLevel='" + aContent.getKlevel() +"'"
					+ " , Content='" + aContent.getContent() +"'"
					+ " , Source='" + aContent.getSource() +"'"
					+ " , Time='" + aContent.getTime() +"'"
					+ " , RelatedTo=" + aContent.getRelatedto() 
					+ " , LOID='" +aContent.getLoid()
					+ " , SectionIDPath='" + aContent.getSectionidpath() +"'"
					+ " , SectionPath='" + aContent.getSectionpath() +"'"
					+ " , CreatedBy='" + aContent.getCreatedby() +"'"
					+ " , Language='" + aContent.getLanguage() +"'"
					+ " where id = " + aContent.getId();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
			pStmt.close();
		}
		return aContent;
	}

	
	@Override
	public List<Content> list(Connection conn) throws Exception {
		List<Content> list = new ArrayList<>();
		
		//SQL
		String sql = "SELECT Id, Extid, Chapter, Content, CreatedBy, KLevel, Language, Source, Time, RelatedTo, LOID ,SectionIDPath, SectionPath from Content";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			//
			list.add(new Content(
					rS.getInt("Id"),
					rS.getString("Extid"),
					rS.getString("Chapter"),
					rS.getString("KLevel"),
					rS.getString("Content"),
					rS.getString("Source"),
					rS.getInt("Time"),
					rS.getInt("RelatedTo"),
					rS.getInt("LOID"),
					rS.getString("SectionIDPath"),
					rS.getString("SectionPath"),
					rS.getString("CreatedBy"),
					rS.getString("Language")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;
	}

}
