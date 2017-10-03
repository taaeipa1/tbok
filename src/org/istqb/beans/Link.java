package org.istqb.beans;

public class Link {
	private int Id;
	private int Ka_id;
	private int Bo_id;
	private int Lo_id;
	private int Content_id;
	private int Rules_id;
	private String Comment;

	
	public Link() {
	}
	public Link(int aId, int aKa_id, int aBo_id, int aLo_id, int aContent_id, int aRules_id, String aComment) {
		Id = aId;
		Ka_id = aKa_id;
		Bo_id = aBo_id;
		Lo_id = aLo_id;
		Content_id = aContent_id;
		Rules_id = aRules_id;
		Comment = aComment;
	}
	public int getId() {
		return Id;
	}
	public int getKa_id() {
		return Ka_id;
	}
	public int getBo_id() {
		return Bo_id;
	}
	public int getLo_id() {
		return Lo_id;
	}
	public int getContent_id() {
		return Content_id;
	}
	public int getRules_id() {
		return Rules_id;
	}
	public String getComment() {
		return Comment;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setKa_id(int ka_id) {
		Ka_id = ka_id;
	}
	public void setBo_id(int bo_id) {
		Bo_id = bo_id;
	}
	public void setLo_id(int lo_id) {
		Lo_id = lo_id;
	}
	public void setContent_id(int content_id) {
		Content_id = content_id;
	}
	public void setRules_id(int rules_id) {
		Rules_id = rules_id;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	
}
