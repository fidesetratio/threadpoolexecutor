package com.app.ofac.model;

import java.util.Date;

public class OfacResult {
	
	private Integer ofacId;

	private String name;
	private String type;
	private String program;
	private String list;
	private Integer score;
	private Date startSearchDate;
	private Date endSearchDate;
	private String address;
	private long startInMilis;
	private long endInMilis;
	public OfacResult() {
		super();
		startSearchDate = new Date();
	}
	
	public OfacResult(Integer ofacId, String name,String address, String type, String program, String list, Integer score) {
		super();
		this.ofacId = ofacId;
		this.name = name;
		this.type = type;
		this.program = program;
		this.list = list;
		this.score = score;
		this.address = address;
		this.startSearchDate = new Date();
	}
	
	
	public Integer getOfacId() {
		return ofacId;
	}
	public void setOfacId(Integer ofacId) {
		this.ofacId = ofacId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getStartInMilis() {
		return startInMilis;
	}

	public void setStartInMilis(long startInMilis) {
		this.startInMilis = startInMilis;
	}

	public long getEndInMilis() {
		return endInMilis;
	}

	public void setEndInMilis(long endInMilis) {
		this.endInMilis = endInMilis;
	}
	
	
}
