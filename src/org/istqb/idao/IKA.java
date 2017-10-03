package org.istqb.idao;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.KA;

public interface IKA {
	public void add (KA KA, Connection conn) throws Exception;
	public void delete (int ID, Connection conn) throws Exception;
	public List<KA> list(Connection conn) throws Exception;
}
