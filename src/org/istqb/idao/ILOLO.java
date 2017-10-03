package org.istqb.idao;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.LOLO;

public interface ILOLO {
	public void add (LOLO LOLO, Connection conn) throws Exception;
	public void delete (int ID, Connection conn) throws Exception;
	public List<LOLO> list(Connection conn) throws Exception;
}
