package org.istqb.bo;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Domain;
import org.istqb.dao.DomainDAO;

public abstract class DomainBO {
	public static void add(Domain Domain, Connection conn) throws Exception {
		if (Domain.getDomain().isEmpty()) {
			throw new Exception("No Domain defined, please define a valid Domain");
		} 
		if (Domain.getValue().isEmpty()) {
			throw new Exception("No Value defined, please enter a valid value");
		}
		if (Domain.getLanguage().isEmpty()) {
			Domain.setLanguage("English");
		}
		new DomainDAO().add(Domain, conn);
	}
	public static void delete(int aID, Connection conn) throws Exception {
		new DomainDAO().delete(aID, conn);
	}
	
	public static Domain edit(int aID, Connection conn) throws Exception {
		return new DomainDAO().edit(aID, conn);
	}
	public static Domain edit(Domain aDomain, Connection conn) throws Exception{
		return new DomainDAO().edit(aDomain, conn);
	}
	
	public static List<Domain> list(Connection conn) throws Exception {
		return new DomainDAO().list(conn);
	}
	
	public static List<Domain> list(String dName, Connection conn) throws Exception {
		return new DomainDAO().list(dName, conn);
	}
	

}
