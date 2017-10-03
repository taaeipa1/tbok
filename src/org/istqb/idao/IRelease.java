package org.istqb.idao;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Release;

public interface IRelease {
	public void add (Release Release, Connection conn) throws Exception;
	public void delete (int ID, Connection conn) throws Exception;
	public List<Release> list(Connection conn) throws Exception;
}
