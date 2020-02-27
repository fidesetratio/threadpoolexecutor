package com.app.ofac.test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import com.app.ofac.model.ApiKeyGenerator;
import com.app.ofac.model.OfacWebService;
import com.app.ofac.model.OfacWebServiceApplication;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OfacDetection {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ApiKeyGenerator apiKey = new ApiKeyGenerator();
		apiKey.setApiKey("a44e99e0-0517-4a62-a405-1aec6e219da7");
		apiKey.setName("Iqbal");
		apiKey.setDate("JSON");
		apiKey.setMinScore("80");
		apiKey.setIncludeAlias(true);
		apiKey.setIncludeEntity(true);
		ObjectMapper objectMapper = new ObjectMapper();
		String body = objectMapper.writeValueAsString(apiKey);
		 String url = "http://search.ofac-api.com/api/v1";
		 Connection.Response  connection = Jsoup.connect(url).method(Connection.Method.POST)
				 .header("Accept","application/json")
				 .header("Content-Type", "application/json")
				 .requestBody(body)
				 .timeout(300000)
				 .ignoreContentType(true) // This is used because Jsoup "approved" content-types parsing is enabled by default by Jsoup
				 .execute();
		 
		 
		 String json = connection.body();
		 ObjectMapper objectMapper1 = new ObjectMapper();
		 objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 System.out.println(connection.body());
		 OfacWebService ofacWebService = objectMapper1.readValue(json, OfacWebService.class);  
		 System.out.println(ofacWebService.isError());
		 System.out.println(ofacWebService.getMatches().size());
		 for(OfacWebServiceApplication app1: ofacWebService.getMatches()){
			 System.out.println(app1.getEntry().getFirstName()+"--"+app1.getScore());	 }
	}

}
