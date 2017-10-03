package org.istqb.bo;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Glossary;
import org.istqb.dao.GlossaryDAO;

public abstract class GlossaryBO {
	public static void add(Glossary Glossary, Connection conn) throws Exception {
		if (Glossary.getTerm().isEmpty()) {
			throw new Exception("No Term defined");
		} 
		if (Glossary.getDefinition().isEmpty()) {
			throw new Exception("No Definition defined");
		}
		Glossary.setLetter(Glossary.getTerm().substring(0,1));  // sets the letter automatically
		new GlossaryDAO().add(Glossary, conn);
	}
	public static void delete(int aID, Connection conn) throws Exception {
		new GlossaryDAO().delete(aID, conn);
	}
	
	public static Glossary edit(int aID, Connection conn) throws Exception {
		return new GlossaryDAO().edit(aID, conn);
	}
	public static Glossary edit(Glossary aGlossary, Connection conn) throws Exception{
		return new GlossaryDAO().edit(aGlossary, conn);
	}
	
	public static List<Glossary> list(Connection conn) throws Exception {
		return new GlossaryDAO().list(conn);
	}

}
