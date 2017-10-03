package org.istqb.idao;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Link;

public interface ILink {
	public void add (Link Link, Connection conn) throws Exception;
	public void delete (int ID, Connection conn) throws Exception;
	public List<Link> list(Connection conn) throws Exception;
}
