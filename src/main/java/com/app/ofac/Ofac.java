package com.app.ofac;
/**
 * Ofac Engine to scrapping website ofac based on search
 * and others.
 * @author Patar Timotius
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.app.ofac.model.OfacAddress;
import com.app.ofac.model.OfacAlias;
import com.app.ofac.model.OfacDetail;
import com.app.ofac.model.OfacIdentification;
import com.app.ofac.model.OfacResult;
import com.app.ofac.model.OfacResultDetail;

public class Ofac {
	private String url;	
	private int timeout;
	private String resultOnText;
	private long getTotalSearchTime;
	
	
	public Ofac() {
		this.url = "https://sanctionssearch.ofac.treas.gov/";
		this.timeout = 10*1000;
	}
	
	public Ofac(String url) {
		this.url = url;
		this.timeout = 10*1000;
	}
	
	
	public List<OfacResult> search(String type,String name,String id,String program,int minimumNameScore,String address,String city,String stateorProvince, String country, String list) throws Exception{
		List<OfacResult> result = new ArrayList<OfacResult>();
		result = submitAndGetResultOfactResult(type,name,id,program,minimumNameScore,address,city,stateorProvince,country,list);
		return result;
	}
	
	
	
	
	
	public OfacResultDetail findByOfacId(Integer ofacId) throws Exception {
		OfacResultDetail ofacResultDetail = new OfacResultDetail();
		ofacResultDetail = submitAndGetResultOfDetail(ofacId);
		return ofacResultDetail;
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
	
	
	
	private List<OfacResult> submitAndGetResultOfactResult(String type,String name,String id,String program,int minimumNameScore,String address,String city,String stateorProvince, String country, String list) throws Exception {
	    	 Date startSearchDate = new Date();
	    	 List<OfacResult> ofacResult = new ArrayList<OfacResult>();
			 Connection.Response  connection = Jsoup.connect(url).method(Connection.Method.GET).execute();
			 Document doc = connection.parse();
			 Element viewState = doc.select("input[name=__VIEWSTATE]").first();
		     Element viewStateGen = doc.select("input[name=__VIEWSTATEGENERATOR]").first();
		     Long startSearch = System.currentTimeMillis();
		     
		     try{
		            Response response = 
		                    Jsoup.connect(url)
		                    .userAgent("Mozilla/5.0")
		                    .timeout(this.timeout)
		                    .method(Method.POST)
		                    .data("ctl00_ctl03_HiddenField", ";;AjaxControlToolkit,+Version=3.5.40412.0,+Culture=neutral,+PublicKeyToken=28f01b0e84b6d53e:en-US:1547e793-5b7e-48fe-8490-03a375b13a33:475a4ef5:5546a2b:d2e10b12:497ef277:effe2a26")
		                    .data("__EVENTTARGET", "")
		                    .data("__EVENTARGUMENT", "")
		                    .data("__VIEWSTATE", viewState.attr("value"))
		                    .data("__VIEWSTATEGENERATOR", viewStateGen.attr("value"))
		                    .data("ctl00$MainContent$ddlType", type)
		                    .data("ctl00$MainContent$txtAddress", address)
		                    .data("ctl00$MainContent$txtLastName", name)
		                    .data("ctl00$MainContent$txtCity", city)
		                    .data("ctl00$MainContent$txtID", id)
		                    .data("ctl00$MainContent$txtState", stateorProvince)
		                    .data("ctl00$MainContent$lstPrograms",program)
		                    .data("ctl00$MainContent$ddlCountry", country)
		                    .data("ctl00$MainContent$ddlList", list)
		                    .data("ctl00$MainContent$Slider1", Integer.toString(minimumNameScore))
		                    .data("ctl00$MainContent$Slider1_Boundcontrol", "100")
		                    .data("ctl00$MainContent$btnSearch","Search")
		                    .cookies(connection.cookies())
		                    .followRedirects(true)
		                    .execute();
		            Document document = response.parse();
		            Element result = document.select("div#ctl00_MainContent_divResults").first();
			        resultOnText = result.text();
			        
			        if(document.select("#gvSearchResults") != null) {
			        	try {
				        	Element table = document.select("#gvSearchResults").get(0); 
					        if(table != null) {
				            Elements rows = table.select("tr");
				            for (int i = 0; i < rows.size(); i++) {
				                Element row = rows.get(i);
				                Elements cols = row.select("td");
				            	String h = cols.html();
				            	Integer ofacId = Integer.parseInt(extractId(h));
				            	String nameofPeople = cols.get(0).text();
				            	String addressOf = cols.get(1).text();
				            	String typeOf = cols.get(2).text();
				            	String programOf = cols.get(3).text();
				            	String listOf = cols.get(4).text();
				            	String scoreOf = cols.get(5).text();
				            	OfacResult oResult = new OfacResult(ofacId, nameofPeople,addressOf, typeOf, programOf, listOf, Integer.parseInt(scoreOf));
				            	oResult.setStartSearchDate(startSearchDate);
				            	oResult.setEndSearchDate(new Date());
				            	oResult.setStartInMilis(startSearch);
				            	oResult.setEndInMilis(System.currentTimeMillis());
				            	ofacResult.add(oResult);
				            }
					        };
				        }catch(IndexOutOfBoundsException e) {
			        		
			        	}
			        };
		            
		            
		            
		     }catch(Exception e) {
		    	 throw e;
		     }
		     getTotalSearchTime = System.currentTimeMillis() - startSearch;
		        
		     return ofacResult;
	}
	private OfacResultDetail submitAndGetResultOfDetail(Integer ofacId) throws Exception{
		OfacResultDetail ofacResultDetail = new OfacResultDetail();
		String urlDetail = url+"Details.aspx?id="+Integer.toString(ofacId);
		Connection.Response  connection = Jsoup.connect(urlDetail).method(Connection.Method.GET).execute();
		Document doc = connection.parse();
		Element table = doc.select("#ctl00_MainContent_pnlDetailsInd table").get(0); //select the first table.
		Elements rows = table.select("tr");
        ofacResultDetail.setStartSearchDate(new Date());
        ofacResultDetail.setStartInMillis(System.currentTimeMillis());
		OfacDetail detail =  new OfacDetail();
		boolean detailAllowed = false;
		String type = "";
	    for (int i = 0; i < rows.size(); i++) {
	    	detailAllowed = true;
	    	Element row = rows.get(i);
	    	
            Elements cols = row.select("td");
            try {
	            String label = cols.get(0).text();
	            String value = cols.get(1).text();
	            
	            String label2 = cols.get(2).text();
	            String value2 = cols.get(3).text();
	            if(label.toUpperCase().contains("TYPE")){
	            	detail.setType(value);
	            	type = value;
	            	
	            }
	            if(type.toUpperCase().contains("INDIVIDUAL")) {
	            	if(label.toUpperCase().contains("LAST NAME")){
	                	detail.setLastName(value);
	                }
	            	if(label.toUpperCase().contains("FIRST NAME")){
	                	detail.setFirstName(value);
	                }
	            	if(label.toUpperCase().contains("TITLE")){
	                	detail.setTitle(value);
	                }
	            	if(label.toUpperCase().contains("DATE OF BIRTH")){
	                	detail.setDobs(value);
	                }
	            	if(label.toUpperCase().contains("PLACE OF BIRTH")){
	                	detail.setPlaceOfBirth(value);
	                }
	            	if(label2.toUpperCase().contains("LIST")) {
	            		detail.setList(value2);
	            	}
	             	if(label2.toUpperCase().contains("PROGRAM")) {
	            		detail.setProgram(value2);
	            	}
	             	if(label2.toUpperCase().contains("NATIONALY")) {
	            		detail.setNationality(value2);
	            	}
	             	if(label2.toUpperCase().contains("CITIZENSHIP")) {
	            		detail.setCitizen(value2);
	            	}
	             	if(label2.toUpperCase().contains("REMARKS")) {
	            		detail.setRemarks(value2);
	            	}
	            }
	           
	            if(type.toUpperCase().equals("ENTITY")) {
	            	if(label.toUpperCase().contains("ENTITY NAME")){
	                	detail.setEntityName(value);
	                }
	            	if(label2.toUpperCase().contains("LIST")) {
	            		detail.setList(value2);
	            	}
	             	if(label2.toUpperCase().contains("PROGRAM")) {
	            		detail.setProgram(value2);
	            	}
	            	if(label2.toUpperCase().contains("REMARKS")) {
	            		detail.setRemarks(value2);
	            	}
	            }
            }catch(IndexOutOfBoundsException e) {
            	
            }
		
            
	    }
		
	    if(detailAllowed) {
	    	ofacResultDetail.setDetails(detail);
	    }else {
	     	ofacResultDetail.setDetails(null);
	    }
		
	    
	    boolean aliasAllowed = false;
	    
	    
	    List<OfacAlias> aliases = new ArrayList<OfacAlias>();
	    table = doc.select("#ctl00_MainContent_gvAliases").get(0); //select the first table.
	    rows = table.select("tr");
        for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
        	aliasAllowed = true;
        	Element row = rows.get(i);
            Elements cols = row.select("td");
           try {
        	   String typeAlias = cols.get(0).text();
        	   String category = cols.get(1).text();
        	   String aliasName = cols.get(2).text();
         	   OfacAlias ofacAlias = new OfacAlias();
         	   ofacAlias.setCategory(category);
         	   ofacAlias.setName(aliasName);
         	   ofacAlias.setType(typeAlias);
         	   aliases.add(ofacAlias);
        	 }catch(IndexOutOfBoundsException e) {
         	  
           }
        };
	    
	    
	    
	    if(aliasAllowed) {
	    	ofacResultDetail.setAliases(aliases);
	    };
	    
	    
	    
	    boolean addressAllowed = false;
	    
	    
	    List<OfacAddress> address = new ArrayList<OfacAddress>();
	    
	    
	    table = doc.select("#ctl00_MainContent_pnlAddress table").get(0); //select the first table.
	    rows = table.select("tr");
        for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
        	addressAllowed = true;
        	Element row = rows.get(i);
            Elements cols = row.select("td");
           try {
        	   String addressA = cols.get(0).text();
        	   String cityA = cols.get(1).text();
        	   String stateProvinceA = cols.get(2).text();
        	   String postalCode = cols.get(3).text();
        	   String country = cols.get(4).text();
        	   
        	   OfacAddress ofacAddress = new OfacAddress();
         	   ofacAddress.setAddress(addressA);
         	   ofacAddress.setCity(cityA);
         	   ofacAddress.setCountry(country);
         	   ofacAddress.setPostalCode(postalCode);
         	   ofacAddress.setStateOrProvince(stateProvinceA);
         	   address.add(ofacAddress);
        	 }catch(IndexOutOfBoundsException e) {
         	  
           }
        };
	    
        
        
        
        
        
        
        
        
        if(addressAllowed) {
        	ofacResultDetail.setAddresses(address);	
        }
        
        
        boolean allowedIdentification = false;
        List<OfacIdentification> identifications = new ArrayList<OfacIdentification>();
	    
        table = doc.select("#ctl00_MainContent_gvIdentification").get(0); //select the first table.
	    rows = table.select("tr");
        for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
        	allowedIdentification = true;
        	Element row = rows.get(i);
            Elements cols = row.select("td");
           try {
        	   String t = cols.get(0).text();
        	   String id = cols.get(1).text();
        	   String country = cols.get(2).text();
         	   String issueDate = cols.get(3).text();
         	   String expireDate = cols.get(4).text();
        	   OfacIdentification identification = new OfacIdentification();
        	   identification.setType(t);
        	   identification.setId(id);
        	   identification.setCountry(country);
        	   identification.setIssueDate(issueDate);
        	   identification.setExpireDate(expireDate);
        	   
         	  identifications.add(identification);
        	 }catch(IndexOutOfBoundsException e) {
         	  
           }
           
           
        };
	    
        if(allowedIdentification) {
        	ofacResultDetail.setIdentifications(identifications);
        }
        ofacResultDetail.setEndSearchDate(new Date());
        ofacResultDetail.setEndInMillis(System.currentTimeMillis());
		
	    return ofacResultDetail;
	}
	private static String extractId(String content) {
		 Pattern pattern =  
			        Pattern.compile("id=([0-9]+)", Pattern.CASE_INSENSITIVE); 
		    Matcher m = pattern.matcher(content); 
			String id = "";
		    while (m.find()) {
		    	id = m.group(1);
		    }
		    return id;
	}

	public String getResultOnText() {
		return resultOnText;
	}

	public void setResultOnText(String resultOnText) {
		this.resultOnText = resultOnText;
	}

	public long getGetTotalSearchTime() {
		return getTotalSearchTime;
	}

	public void setGetTotalSearchTime(long getTotalSearchTime) {
		this.getTotalSearchTime = getTotalSearchTime;
	}
}
