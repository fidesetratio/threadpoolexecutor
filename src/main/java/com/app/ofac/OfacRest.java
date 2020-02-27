package com.app.ofac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import com.app.ofac.model.ApiKeyGenerator;
import com.app.ofac.model.OfacResult;
import com.app.ofac.model.OfacWebService;
import com.app.ofac.model.OfacWebServiceApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OfacRest {
	private String url;	
	private int timeout;
	private ApiKeyGenerator apiKey;
	public OfacRest() {
		this.url = "http://search.ofac-api.com/api/v1";
		this.timeout = 300000;
		apiKey = new ApiKeyGenerator();
		apiKey.setApiKey("a44e99e0-0517-4a62-a405-1aec6e219da7");
		apiKey.setName("Iqbal");
		apiKey.setDate("JSON");
		apiKey.setMinScore("80");
		apiKey.setIncludeAlias(true);
		apiKey.setIncludeEntity(true);
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	public List<OfacResult> search(String name,int minimumScore) throws Exception{
		List<OfacResult> result = new ArrayList<OfacResult>();
		apiKey.setName(name);
		apiKey.setMinScore(Integer.toString(minimumScore));
		result = submitAndGetResultOfactResult(apiKey);
		return result;
	}
	private OfacWebService submitAndGetResultOfactResultTemp(ApiKeyGenerator apiKey) throws IOException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String body = objectMapper.writeValueAsString(apiKey);
			 Connection.Response  connection = Jsoup.connect(url).method(Connection.Method.POST)
					 .header("Accept","application/json")
					 .header("Content-Type", "application/json")
					 .requestBody(body)
					 .timeout(this.timeout)
					 .ignoreContentType(true) // This is used because Jsoup "approved" content-types parsing is enabled by default by Jsoup
					 .execute();
			 String json = connection.body();
			 ObjectMapper objectMapper1 = new ObjectMapper();
			 objectMapper1.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			 OfacWebService ofacWebService = objectMapper1.readValue(json, OfacWebService.class);  
			 return ofacWebService;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
private List<OfacResult> submitAndGetResultOfactResult(ApiKeyGenerator apiKey) throws IOException{
		OfacWebService ofacWebService = submitAndGetResultOfactResultTemp(apiKey);
		List<OfacResult> result = new ArrayList<OfacResult>();
		if(ofacWebService != null){
			if(!ofacWebService.isError()){
				for(OfacWebServiceApplication app : ofacWebService.getMatches()){
					
					if(app.getEntry() != null){
						OfacResult o = new OfacResult();
						String name = "";
						if(app.getEntry().getFirstName() != null)
						if(!app.getEntry().getFirstName().equals("null")){
							name = app.getEntry().getFirstName();
						}

						if(app.getEntry().getLastName() != null)
						if(!app.getEntry().getLastName().equals("null"))
						{
							name = name+" "+app.getEntry().getLastName();
						}
						o.setName(name.trim());
						if(app.getEntry().getProgramList() != null)
						o.setProgram(String.join("",app.getEntry().getProgramList().getProgram()));
						o.setScore(Math.round(app.getScore()));
						result.add(o);
					};
					
				}
			}
		}
			
		return result;
		
		
	}
}
