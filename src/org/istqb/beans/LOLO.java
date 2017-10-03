package org.istqb.beans;

public class LOLO {
	private int Id;
	private int Lo1;
	private int Lo2;
	private int Relatedto;
	private String Createdby;
	private String Sectionidpath;
	private String Sectionpatch;

	public LOLO() {
		
	}
	
	public LOLO(int aId, int aLo1, int aLo2, int aRelatedto, String aCreatedby, String aSectionidpath, String aSectionpatch) {
		Id = aId;
		Lo1 = aLo1;
		Lo2 = aLo2;
		Relatedto = aRelatedto;
		Createdby = aCreatedby;
		Sectionidpath = aSectionidpath;
		Sectionpatch = aSectionpatch;
	}

	public int getId() {
		return Id;
	}

	public int getLo1() {
		return Lo1;
	}

	public int getLo2() {
		return Lo2;
	}

	public int getRelatedto() {
		return Relatedto;
	}

	public String getCreatedby() {
		return Createdby;
	}

	public String getSectionidpath() {
		return Sectionidpath;
	}

	public String getSectionpatch() {
		return Sectionpatch;
	}

	public void setId(int id) {
		Id = id;
	}

	public void setLo1(int lo1) {
		Lo1 = lo1;
	}

	public void setLo2(int lo2) {
		Lo2 = lo2;
	}

	public void setRelatedto(int relatedto) {
		Relatedto = relatedto;
	}

	public void setCreatedby(String createdby) {
		Createdby = createdby;
	}

	public void setSectionidpath(String sectionidpath) {
		Sectionidpath = sectionidpath;
	}

	public void setSectionpatch(String sectionpatch) {
		Sectionpatch = sectionpatch;
	}
	
	
}

	