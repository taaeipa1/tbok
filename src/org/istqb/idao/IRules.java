package org.istqb.idao;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Rules;

public interface IRules {
	public void add (Rules Rules, Connection conn) throws Exception;
	public void delete (int ID, Connection conn) throws Exception;
	public List<Rules> list(Connection conn) throws Exception;
}
