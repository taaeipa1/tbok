package org.istqb.idao;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Glossary;

public interface IGlossary {
	public void add (Glossary Glossary, Connection conn) throws Exception;
	public void delete (int ID, Connection conn) throws Exception;
	public List<Glossary> list(Connection conn) throws Exception;
}
