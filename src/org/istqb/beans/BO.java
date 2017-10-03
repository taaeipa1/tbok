package org.istqb.beans;

public class BO {

	private int Id;
	private String Extid;
	private String Description;
	private String Language;
	public BO() {
	}
	public BO(int aID, String aExtID, String aDescription, String aLanguage) {
		Id = aID;
		Extid = aExtID;
		Description = aDescription;
		Language = aLanguage;
	}
	public int getId() {
		return Id;
	}
	public String getExtid() {
		return Extid;
	}
	public String getDescription() {
		return Description;
	}
	public String getLanguage() {
		return Language;
	}
	public void setId(int aID) {
		Id = aID;
	}
	public void setExtid(String aExtID) {
		Extid = aExtID;
	}
	public void setDescription(String aDescription) {
		Description = aDescription;
	}
	public void setLanguage(String aLanguage) {
		Language = aLanguage;
	}
	
}
