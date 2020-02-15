package com.app.ofac.model;

import java.util.Date;
import java.util.List;

public class OfacResultDetail {
	private Integer ofacId;
	private OfacDetail details;
	private List<OfacIdentification> identifications;
	private List<OfacAlias> aliases;
	private List<OfacAddress> addresses;
	private Date startSearchDate;
	private Date endSearchDate;
	private Long startInMillis;
	private Long endInMillis;
	
	public Integer getOfacId() {
		return ofacId;
	}
	public void setOfacId(Integer ofacId) {
		this.ofacId = ofacId;
	}
	public OfacDetail getDetails() {
		return details;
	}
	public void setDetails(OfacDetail details) {
		this.details = details;
	}
	public List<OfacIdentification> getIdentifications() {
		return identifications;
	}
	public void setIdentifications(List<OfacIdentification> identifications) {
		this.identifications = identifications;
	}
	public List<OfacAlias> getAliases() {
		return aliases;
	}
	public void setAliases(List<OfacAlias> aliases) {
		this.aliases = aliases;
	}
	public List<OfacAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<OfacAddress> addresses) {
		this.addresses = addresses;
	}
	public Date getStartSearchDate() {
		return startSearchDate;
	}
	public void setStartSearchDate(Date startSearchDate) {
		this.startSearchDate = startSearchDate;
	}
	public Date getEndSearchDate() {
		return endSearchDate;
	}
	public void setEndSearchDate(Date endSearchDate) {
		this.endSearchDate = endSearchDate;
	}
	public Long getStartInMillis() {
		return startInMillis;
	}
	public void setStartInMillis(Long startInMillis) {
		this.startInMillis = startInMillis;
	}
	public Long getEndInMillis() {
		return endInMillis;
	}
	public void setEndInMillis(Long endInMillis) {
		this.endInMillis = endInMillis;
	}
	

}
