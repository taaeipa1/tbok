package org.istqb.bo;

import java.sql.Connection;
import java.util.List;

import org.istqb.beans.Release;
import org.istqb.dao.ReleaseDAO;

public abstract class ReleaseBO {
	public static void add(Release Release, Connection conn) throws Exception {
		if (Release.getSource().isEmpty()) {
			throw new Exception("No Syllabus defined");
		}
		if (Release.getLanguage().isEmpty()) {
			throw new Exception("No Language defined");
		}
		if (Release.getTitle().isEmpty()) {
			throw new Exception("No Release-Title defined");
		}
		new ReleaseDAO().add(Release, conn);
	}
	public static void delete(int aID, Connection conn) throws Exception {
		new ReleaseDAO().delete(aID, conn);
	}
	
	public static Release edit(int aID, Connection conn) throws Exception {
		return new ReleaseDAO().edit(aID, conn);
	}
	public static Release edit(Release aRelease, Connection conn) throws Exception{
		return new ReleaseDAO().edit(aRelease, conn);
	}
	
	public static List<Release> list(Connection conn) throws Exception {
		return new ReleaseDAO().list(conn);
	}

}
