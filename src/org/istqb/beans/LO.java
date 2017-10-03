package org.istqb.beans;


public class LO {
	private int Id;
	private String Extid;
	private String Topic;
	private String Description;
	private String Level;
	private String Source;
	private int Relatedto;
	private int Contentid;
	private String Sectionidpath;
	private String Sectionpath;
	private String Createdby;
	private String Language;
	
	public LO() {
		
	}
	public LO(int aId, String aExtid, String aTopic, String aDescription, String aLevel, String aSource, int aRelatedto, int aContentid, String aSectionidpath, String aSectionpath, String aCreatedby, String aLanguage){
		Id = aId;
		Extid = aExtid;
		Topic = aTopic;
		Description = aDescription;
		Level = aLevel;
		Source = aSource;
		Relatedto = aRelatedto;
		Contentid = aContentid;
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
	public String getTopic() {
		return Topic;
	}
	public String getDescription() {
		return Description;
	}
	public String getLevel() {
		return Level;
	}
	public String getSource() {
		return Source;
	}
	public int getRelatedto() {
		return Relatedto;
	}
	public int getContentid() {
		return Contentid;
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
	public void setTopic(String topic) {
		Topic = topic;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setLevel(String level) {
		Level = level;
	}
	public void setSource(String source) {
		Source = source;
	}
	public void setRelatedto(int relatedto) {
		Relatedto = relatedto;
	}
	public void setContentid(int contentid) {
		Contentid = contentid;
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
