package org.istqb.bo;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.KA;
import org.istqb.dao.KADAO;

public abstract class KABO {
	public static void add(KA KA, Connection conn) throws Exception {
		if (KA.getKnowledgearea().isEmpty()) {
			throw new Exception("No Knowledgearea defined");
		}
		new KADAO().add(KA,conn);
	}
	public static void delete(int aID, Connection conn) throws Exception {
		new KADAO().delete(aID, conn);
	}
	
	public static KA edit(int aID, Connection conn) throws Exception {
		return new KADAO().edit(aID, conn);
	}
	public static KA edit(KA aKA, Connection conn) throws Exception{
		return new KADAO().edit(aKA, conn);
	}
	
	public static List<KA> list(Connection conn) throws Exception {
		return new KADAO().list(conn);
	}
	
}
