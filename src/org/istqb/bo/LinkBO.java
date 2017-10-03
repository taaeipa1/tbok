package org.istqb.bo;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Link;
import org.istqb.dao.LinkDAO;

public abstract class LinkBO {
	public static void add(Link Link, Connection conn) throws Exception {
		if (Link.getContent_id() == 0) {
			throw new Exception("No Content defined");
		} 
		new LinkDAO().add(Link,conn);
	}
	public static void delete(int aID, Connection conn) throws Exception {
		new LinkDAO().delete(aID, conn);
	}
	
	public static Link edit(int aID, Connection conn) throws Exception {
		return new LinkDAO().edit(aID, conn);
	}
	public static Link edit(Link aLink, Connection conn) throws Exception{
		return new LinkDAO().edit(aLink, conn);
	}
	
	public static List<Link> list(Connection conn) throws Exception {
		return new LinkDAO().list(conn);
	}

}
