package org.istqb.bo;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.LO;
import org.istqb.dao.LODAO;

public abstract class LOBO {
	public static void add(LO LO, Connection conn) throws Exception {
		if (LO.getExtid().isEmpty()) {
			throw new Exception("No ExtID defined, please define a valid ExtID");
		} else {
			if (LO.getExtid().length() == 0) {
				throw new Exception("No ExtID defined, please define a valid ExtID");
			}
		}
		if (LO.getDescription().isEmpty()) {
			throw new Exception("No Description defined, please enter a valid description");
		}
		if (LO.getLanguage().isEmpty()) {
			LO.setLanguage("English");
		}
		new LODAO().add(LO,conn);
	}
	public static void delete(int aID, Connection conn) throws Exception {
		new LODAO().delete(aID, conn);
	}
	
	public static LO edit(int aID, Connection conn) throws Exception {
		return new LODAO().edit(aID, conn);
	}
	public static LO edit(LO aLO, Connection conn) throws Exception{
		return new LODAO().edit(aLO, conn);
	}
	
	public static List<LO> list(Connection conn) throws Exception {
		return new LODAO().list(conn);
	}
	
	
	public static List<LO> list(String aParameter, Connection conn) throws Exception {
		return new LODAO().list(aParameter, conn);
	}
	

}
