package org.istqb.beans;

import java.sql.Date;

public class Content {

	private int Id;
	private String Extid;
	private String Chapter;
	private String Klevel; // K-Level
	private String Content;
	private String Source;
	private int Time;
	private int Relatedto;
	private int Loid;
	private String Sectionidpath;
	private String Sectionpath;
	private String Createdby;
	private String Language;
	
	public Content() {
	}
	public Content(int aId,	String aExtid, String aChapter, String aKlevel, String aContent, String aSource, int aTime, int aRelatedto, int aLoid, String aSectionidpath, String aSectionpath, String aCreatedby, String aLanguage) {
		Id = aId;
		Extid = aExtid;
		Chapter = aChapter;
		Klevel = aKlevel;
		Content = aContent;
		Source = aSource;
		Time = aTime;
		Relatedto = aRelatedto;
		Loid = aLoid;
		Sectionidpath = aSectionidpath;
		Sectionpath = aSectionpath;
		Createdby = aCreatedby;
		Language = aLanguage;
	}
	public int getId() {
		return Id;
	}
	public String getExtid() {
		return Extid;
	}
	public String getChapter() {
		return Chapter;
	}
	public String getKlevel() {
		return Klevel;
	}
	public String getContent() {
		return Content;
	}
	public String getSource() {
		return Source;
	}
	public int getTime() {
		return Time;
	}
	public int getRelatedto() {
		return Relatedto;
	}
	public int getLoid() {
		return Loid;
	}
	public String getSectionidpath() {
		return Sectionidpath;
	}
	public String getSectionpath() {
		return Sectionpath;
	}
	public String getCreatedby() {
		return Createdby;
	}
	public String getLanguage() {
		return Language;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setExtid(String extid) {
		Extid = extid;
	}
	public void setChapter(String chapter) {
		Chapter = chapter;
	}
	public void setKlevel(String klevel) {
		Klevel = klevel;
	}
	public void setContent(String content) {
		Content = content;
	}
	public void setSource(String source) {
		Source = source;
	}
	public void setTime(int time) {
		Time = time;
	}
	public void setRelatedto(int relatedto) {
		Relatedto = relatedto;
	}
	public void setLoid(int loid) {
		Loid = loid;
	}
	public void setSectionidpath(String sectionidpath) {
		Sectionidpath = sectionidpath;
	}
	public void setSectionpath(String sectionpath) {
		Sectionpath = sectionpath;
	}
	public void setCreatedby(String createdby) {
		Createdby = createdby;
	}
	public void setLanguage(String language) {
		Language = language;
	}

}
