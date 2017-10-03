package org.istqb.idao;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Content;

public interface IContent {
	public void add (Content Content, Connection conn) throws Exception;
	public void delete (int ID, Connection conn) throws Exception;
	public List<Content> list(Connection conn) throws Exception;
}
