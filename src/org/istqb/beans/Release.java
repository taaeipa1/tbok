package org.istqb.beans;

import java.sql.Date;

public class Release {
	private int Id;
	private String Source;
	private String Language;
	private String Title;
	private Date Sunset;
	private Date Sunrise;
	
	public Release() {
		
	}
	public Release(int aId, String aSource, String aLanguage, String aTitle, Date aSunset, Date aSunrise) {
		Id = aId;
		Source = aSource;
		Language = aLanguage;
		Title = aTitle;
		Sunset = aSunset;
		Sunrise = aSunrise;
	}
	public int getId() {
		return Id;
	}
	public String getSource() {
		return Source;
	}
	public String getLanguage() {
		return Language;
	}
	public String getTitle() {
		return Title;
	}
	public Date getSunset() {
		return Sunset;
	}
	public Date getSunrise() {
		return Sunrise;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setSource(String source) {
		Source = source;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public void setSunset(Date sunset) {
		Sunset = sunset;
	}
	public void setSunrise(Date sunrise) {
		Sunrise = sunrise;
	}

}
