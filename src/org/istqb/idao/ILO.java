package org.istqb.idao;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.LO;

public interface ILO {
	public void add (LO LO, Connection conn) throws Exception;
	public void delete (int ID, Connection conn) throws Exception;
	public List<LO> list(Connection conn) throws Exception;
}
