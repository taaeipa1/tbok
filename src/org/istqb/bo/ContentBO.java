package org.istqb.bo;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Content;
import org.istqb.dao.ContentDAO;

public abstract class ContentBO {
	public static void add(Content content, Connection conn) throws Exception {
		if (content.getExtid().isEmpty()) {
			throw new Exception("No ExtID defined, please define a valid ExtID");
		} else {
			if (content.getExtid().length() == 0) {
				throw new Exception("No ExtID defined, please define a valid ExtID");
			}
		}
		if (content.getChapter().isEmpty()) {
			throw new Exception("No Chapter defined, please enter a valid description");
		}
		if (content.getLanguage().isEmpty()) {
			content.setLanguage("English");
		}
		new ContentDAO().add(content,conn);
	}
	public static void delete(int aID, Connection conn) throws Exception {
		new ContentDAO().delete(aID, conn);
	}
	
	public static Content edit(int aID, Connection conn) throws Exception {
		return new ContentDAO().edit(aID, conn);
	}
	public static Content edit(Content aContent, Connection conn) throws Exception{
		return new ContentDAO().edit(aContent, conn);
	}
	
	public static List<Content> list(Connection conn) throws Exception {
		return new ContentDAO().list(conn);
	}

}
