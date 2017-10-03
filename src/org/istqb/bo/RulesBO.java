package org.istqb.bo;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Rules;
import org.istqb.dao.RulesDAO;

public abstract class RulesBO {
	public static void add(Rules Rules, Connection conn) throws Exception {
		if (Rules.getArea().isEmpty()) {
			throw new Exception("No Area defined");
		}
		if (Rules.getRule().isEmpty()) {
			throw new Exception("No Rule defined");
		}
		if (Rules.getLanguage().isEmpty()) {
			Rules.setLanguage("English");
		}
		new RulesDAO().add(Rules, conn);
	}
	public static void delete(int aID, Connection conn) throws Exception {
		new RulesDAO().delete(aID, conn);
	}
	
	public static Rules edit(int aID, Connection conn) throws Exception {
		return new RulesDAO().edit(aID, conn);
	}
	public static Rules edit(Rules aRules, Connection conn) throws Exception{
		return new RulesDAO().edit(aRules, conn);
	}
	
	public static List<Rules> list(Connection conn) throws Exception {
		return new RulesDAO().list(conn);
	}

}
