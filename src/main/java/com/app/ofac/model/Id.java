package com.app.ofac.model;

public class Id {
  private int uid;
  private String idType;
  private String idNumber;
  private String idCountry;
  private String issueDate;
  private String expirationDate;
  
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getIdType() {
	return idType;
}
public void setIdType(String idType) {
	this.idType = idType;
}
public String getIdNumber() {
	return idNumber;
}
public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
}
public String getIdCountry() {
	return idCountry;
}
public void setIdCountry(String idCountry) {
	this.idCountry = idCountry;
}
public String getIssueDate() {
	return issueDate;
}
public void setIssueDate(String issueDate) {
	this.issueDate = issueDate;
}
public String getExpirationDate() {
	return expirationDate;
}
public void setExpirationDate(String expirationDate) {
	this.expirationDate = expirationDate;
}
}
