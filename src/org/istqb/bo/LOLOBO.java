package org.istqb.bo;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.LOLO;
import org.istqb.dao.LOLODAO;

public abstract class LOLOBO {
	public static void add(LOLO LOLO, Connection conn) throws Exception {
		if (LOLO.getLo1() == 0) {
			throw new Exception("No Learning objective link defined");
		}
		if (LOLO.getLo2() == 0) {
			throw new Exception("No Learning objective link defined");
		}

		new LOLODAO().add(LOLO,conn);
	}
	public static void delete(int aID, Connection conn) throws Exception {
		new LOLODAO().delete(aID, conn);
	}
	
	public static LOLO edit(int aID, Connection conn) throws Exception {
		return new LOLODAO().edit(aID, conn);
	}
	public static LOLO edit(LOLO aLOLO, Connection conn) throws Exception{
		return new LOLODAO().edit(aLOLO, conn);
	}
	
	public static List<LOLO> list(Connection conn) throws Exception {
		return new LOLODAO().list(conn);
	}

}
