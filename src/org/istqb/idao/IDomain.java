package org.istqb.idao;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Domain;

public interface IDomain {
	public void add (Domain Domain, Connection conn) throws Exception;
	public void delete (int ID, Connection conn) throws Exception;
	public List<Domain> list(Connection conn) throws Exception;
}
