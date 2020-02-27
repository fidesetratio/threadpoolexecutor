package com.app.ofac.model;

public class OfacWebServiceApplication {
	private float score;
	  private String dob;
	  private  OfacWebServiceEntry entry;
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public OfacWebServiceEntry getEntry() {
		return entry;
	}
	public void setEntry(OfacWebServiceEntry entry) {
		this.entry = entry;
	}
}
