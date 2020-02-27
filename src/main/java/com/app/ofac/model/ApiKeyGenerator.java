package com.app.ofac.model;

public class ApiKeyGenerator {
	private String apiKey;
	private String name;
	private String date;
	private String minScore;
	private boolean includeAlias;
	private boolean includeEntity;
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMinScore() {
		return minScore;
	}
	public void setMinScore(String minScore) {
		this.minScore = minScore;
	}
	public boolean isIncludeAlias() {
		return includeAlias;
	}
	public void setIncludeAlias(boolean includeAlias) {
		this.includeAlias = includeAlias;
	}
	public boolean isIncludeEntity() {
		return includeEntity;
	}
	public void setIncludeEntity(boolean includeEntity) {
		this.includeEntity = includeEntity;
	}
	
}
