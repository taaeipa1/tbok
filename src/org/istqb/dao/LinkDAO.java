package org.istqb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.istqb.beans.Link;
import org.istqb.idao.ILink;

public class LinkDAO implements ILink {

	@Override
	public void add(Link Link, Connection conn) throws Exception {
		String sql = "INSERT INTO Link (Ka_id, Bo_id, Lo_id, Content_id, Rules_id, Comment) "
				+ "VALUES (?,?,?,?,?,?)";
	
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setInt(1, Link.getKa_id());
		pStmt.setInt(2, Link.getBo_id());
		pStmt.setInt(3, Link.getLo_id());
		pStmt.setInt(4, Link.getContent_id());
		pStmt.setInt(5, Link.getRules_id());
		pStmt.setString(6, Link.getComment());
		pStmt.execute();
		pStmt.close();
		
	}

	public Link edit(int aID, Connection conn) throws Exception {
		String sql = "SELECT Id, Ka_id, Bo_id, Lo_id, Content_id, Rules_id, Comment from Link where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		Link link;
		if (rS.next()) {
			link = new Link(rS.getInt("Id"), rS.getInt("Ka_id"), rS.getInt("Bo_id"), rS.getInt("Lo_id"), rS.getInt("Content_id"), rS.getInt("Rules_id"), rS.getString("Comment"));
		} else {
			link = new Link(0,0,0,0,0,0,"Justification");
		}
		rS.close();
		return link;
	}
	
	public Link edit(Link aLink, Connection conn) throws Exception {
		if (aLink.getId()>0) {
			String sql = "update Link "
					+ " set Ka_id='" + aLink.getKa_id() +"'"
					+ " , Bo_id='" + aLink.getBo_id() +"'"
					+ " , Lo_id='" + aLink.getLo_id() +"'"
					+ " , Content_id='" + aLink.getContent_id() +"'"					
					+ " , Rules_id='" + aLink.getRules_id() +"'"
					+ " , Comment='" + aLink.getComment() +"'"
					+ " where id = " + aLink.getId();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
			pStmt.close();
		}
		return aLink;
	}

	@Override
	public void delete(int aID, Connection conn) throws Exception {
		String sql = "delete from Link where id = " + aID;
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.execute(sql);
		pStmt.close();
		
	}

	@Override
	public List<Link> list(Connection conn) throws Exception {
		List<Link> list = new ArrayList<>();
		
		//SQL
		String sql = "SELECT Id, Ka_id, Bo_id, Lo_id, Content_id, Rules_id, Comment from Link";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rS = pStmt.executeQuery();
		
		while (rS.next()){
			list.add(new Link(
					rS.getInt("Id"), 
					rS.getInt("Ka_id"),
					rS.getInt("Bo_id"),
					rS.getInt("Lo_id"),
					rS.getInt("Content_id"),
					rS.getInt("Rules_id"),
					rS.getString("Comment")));
		}
		
		rS.close();
		pStmt.close();
		
		return list;

	}

}
