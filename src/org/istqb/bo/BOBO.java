package org.istqb.bo;

import org.istqb.beans.BO;
import org.istqb.dao.BODAO;
import java.sql.Connection;
import java.util.List;

public abstract class BOBO {
	public static void add(BO BO, Connection conn) throws Exception {
		if (BO.getExtid().isEmpty()) {
			throw new Exception("No ExtID defined, please define a valid ExtID");
		} else {
			if (BO.getExtid().length() == 0) {
				throw new Exception("No ExtID defined, please define a valid ExtID");
			}
		}
		if (BO.getDescription().isEmpty()) {
			throw new Exception("No Description defined, please enter a valid description");
		}
		if (BO.getLanguage().isEmpty()) {
			BO.setLanguage("English");
		}
		new BODAO().add(BO,conn);
	}
	public static void delete(int aID, Connection conn) throws Exception {
		new BODAO().delete(aID, conn);
	}
	
	public static BO edit(int aID, Connection conn) throws Exception {
		return new BODAO().edit(aID, conn);
	}
	public static BO edit(BO aBO, Connection conn) throws Exception{
		return new BODAO().edit(aBO, conn);
	}
	
	public static List<BO> list(Connection conn) throws Exception {
		return new BODAO().list(conn);
	}
}
