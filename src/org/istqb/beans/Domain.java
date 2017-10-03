package org.istqb.beans;

public class Domain {
	private int Id;
	private String Domain;
	private String Value;
	private String Language;

	public Domain() {
		
	}
	public Domain(int aId, String aDomain, String aValue, String aLanguage){
		Id = aId;
		Domain = aDomain;
		Value = aValue;
		Language = aLanguage;
	}
	public int getId() {
		return Id;
	}
	public String getDomain() {
		return Domain;
	}
	public String getValue() {
		return Value;
	}
	public String getLanguage() {
		return Language;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	public void setValue(String value) {
		Value = value;
	}
	public void setLanguage(String language) {
		Language = language;
	}

}
