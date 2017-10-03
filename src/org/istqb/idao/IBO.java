package org.istqb.idao;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.BO;

public interface IBO {
	public void add (BO BO, Connection conn) throws Exception;
	public void delete (int ID, Connection conn) throws Exception;
	public BO edit(int aID, Connection conn) throws Exception;
	public BO edit(BO aBO, Connection conn) throws Exception;
	public List<BO> list(Connection conn) throws Exception;
}
