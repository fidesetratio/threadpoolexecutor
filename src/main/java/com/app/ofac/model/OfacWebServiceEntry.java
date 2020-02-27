package com.app.ofac.model;

import java.util.List;

public class OfacWebServiceEntry {
	  private float uid;
	  private String firstName;
	  private String lastName;
	  private String sdnType;
	  
	  private OfacWebServiceDateOfBirth dateOfBirthList;
	  private ProgramList programList;
	  private AkaList akaList;
	  private PlaceOfBirthList placeOfBirthList;
	  private String remarks;
	  private IdList idList;
	  private NationalityList nationalityList;
	  private String title;
	  private AddressList addressList;
	  private CitizenshipList citizenshipList;
	  
	  
	  
	public float getUid() {
		return uid;
	}
	public void setUid(float uid) {
		this.uid = uid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSdnType() {
		return sdnType;
	}
	public void setSdnType(String sdnType) {
		this.sdnType = sdnType;
	}
	public OfacWebServiceDateOfBirth getDateOfBirthList() {
		return dateOfBirthList;
	}
	public void setDateOfBirthList(OfacWebServiceDateOfBirth dateOfBirthList) {
		this.dateOfBirthList = dateOfBirthList;
	}
	public ProgramList getProgramList() {
		return programList;
	}
	public void setProgramList(ProgramList programList) {
		this.programList = programList;
	}
	public AkaList getAkaList() {
		return akaList;
	}
	public void setAkaList(AkaList akaList) {
		this.akaList = akaList;
	}
	public PlaceOfBirthList getPlaceOfBirthList() {
		return placeOfBirthList;
	}
	public void setPlaceOfBirthList(PlaceOfBirthList placeOfBirthList) {
		this.placeOfBirthList = placeOfBirthList;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public IdList getIdList() {
		return idList;
	}
	public void setIdList(IdList idList) {
		this.idList = idList;
	}
	public NationalityList getNationalityList() {
		return nationalityList;
	}
	public void setNationalityList(NationalityList nationalityList) {
		this.nationalityList = nationalityList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAddressList(AddressList addressList) {
		this.addressList = addressList;
	}
	public CitizenshipList getCitizenshipList() {
		return citizenshipList;
	}
	public void setCitizenshipList(CitizenshipList citizenshipList) {
		this.citizenshipList = citizenshipList;
	}
	public AddressList getAddressList() {
		return addressList;
	}
	
}
