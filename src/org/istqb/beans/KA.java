package org.istqb.beans;


public class KA {
	private int Id;
	private String Knowledgearea;
	
	public KA() {
	}
	public KA(int aID, String aKnowledgearea) {
		Id = aID;
		Knowledgearea = aKnowledgearea;
	}
	public int getId() {
		return Id;
	}
	public String getKnowledgearea() {
		return Knowledgearea;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setKnowledgearea(String knowledgearea) {
		Knowledgearea = knowledgearea;
	}

}
