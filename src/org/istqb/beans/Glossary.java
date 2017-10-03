package org.istqb.beans;

public class Glossary {
	private int Id;
	private String Term;
	private String Definition;
	private String Area;
	private String Letter;

	public Glossary(){
		
	}
	public Glossary(int aId, String aTerm, String aDefinition, String aArea, String aLetter){
		Id = aId;
		Term = aTerm;
		Definition = aDefinition;
		Area = aArea;
		Letter = aLetter;
	}
	public int getId() {
		return Id;
	}
	public String getTerm() {
		return Term;
	}
	public String getDefinition() {
		return Definition;
	}
	public String getArea() {
		return Area;
	}
	public String getLetter() {
		return Letter;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setTerm(String term) {
		Term = term;
	}
	public void setDefinition(String definition) {
		Definition = definition;
	}
	public void setArea(String area) {
		Area = area;
	}
	public void setLetter(String letter) {
		Letter = letter;
	}
	

}
