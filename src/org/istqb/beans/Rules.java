package org.istqb.beans;


public class Rules {

	private int Id;
	private String Area;
	private String Rule;
	private String Language;
	
	public Rules() {
		
	}
	
	public Rules(int aId, String aArea, String aRule, String aLanguage) {
		Id = aId;
		Area = aArea;
		Rule = aRule;
		Language = aLanguage;
	}

	public int getId() {
		return Id;
	}

	public String getArea() {
		return Area;
	}

	public String getRule() {
		return Rule;
	}

	public String getLanguage() {
		return Language;
	}

	public void setId(int id) {
		Id = id;
	}

	public void setArea(String area) {
		Area = area;
	}

	public void setRule(String rule) {
		Rule = rule;
	}

	public void setLanguage(String language) {
		Language = language;
	}
	
	
}
