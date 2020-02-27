package com.app.ofac.model;

public class Nationality {
	private int uid;
	private String country;
	private boolean mainEntry;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isMainEntry() {
		return mainEntry;
	}
	public void setMainEntry(boolean mainEntry) {
		this.mainEntry = mainEntry;
	}
}
