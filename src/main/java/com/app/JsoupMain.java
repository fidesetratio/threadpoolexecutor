package com.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;

public class JsoupMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 String url = "https://sanctionssearch.ofac.treas.gov/";
	        
		 Connection.Response  connection = Jsoup.connect(url).method(Connection.Method.GET).execute();
		 
		  Document doc = connection.parse();

	        Element eventValidation = doc.select("input[name=__EVENTVALIDATION]").first();
	        Element viewState = doc.select("input[name=__VIEWSTATE]").first();
	        Element viewStateGen = doc.select("input[name=__VIEWSTATEGENERATOR]").first();

	        Element previouspAge = doc.select("input[name=__PREVIOUSPAGE]").first();
	        Element ctl00_ctl03_HiddenField = doc.select("input[name=ctl00_ctl03_HiddenField]").first();
	        Element ctl00$MainContent$Slider1 = doc.select("input[name=ctl00$MainContent$Slider1]").first();
	        
	        System.out.println(viewState.attr("value"));
	        System.out.println(ctl00_ctl03_HiddenField.attr("value"));
	        System.out.println(viewStateGen.attr("value"));
	        System.out.println(ctl00$MainContent$Slider1.attr("value"));
	   //     System.out.println(previouspAge.attr("value"));
		/*
		 * Connection.Response response2 = Jsoup.connect("yourloginpage")
		 * .method(Connection.Method.GET) .execute();
		 */
	        
	        String title = doc.title();
	        FormElement form = doc.select("[name=aspnetForm]").forms().get(0);
	        System.out.println(title);
	        
	        
	        try{
	        	
	        	url = "https://sanctionssearch.ofac.treas.gov";
	            
	            Response response = 
	                    Jsoup.connect(url)
	                    .userAgent("Mozilla/5.0")
	                    .timeout(10 * 1000)
	                    .method(Method.POST)
	                    .data("ctl00_ctl03_HiddenField", ";;AjaxControlToolkit,+Version=3.5.40412.0,+Culture=neutral,+PublicKeyToken=28f01b0e84b6d53e:en-US:1547e793-5b7e-48fe-8490-03a375b13a33:475a4ef5:5546a2b:d2e10b12:497ef277:effe2a26")
	                    .data("__EVENTTARGET", "")
	                    .data("__EVENTARGUMENT", "")
	                    .data("__VIEWSTATE", viewState.attr("value"))
	                    .data("__VIEWSTATEGENERATOR", viewStateGen.attr("value"))
	                    .data("ctl00$MainContent$ddlType", "")
	                    .data("ctl00$MainContent$txtAddress", "")
	                    .data("ctl00$MainContent$txtLastName", "Osama")
	                    .data("ctl00$MainContent$txtCity", "")
	                    .data("ctl00$MainContent$txtID", "")
	                    .data("ctl00$MainContent$txtState", "")
	                    .data("ctl00$MainContent$lstPrograms", "")
	                    .data("ctl00$MainContent$ddlCountry", "")
	                    .data("ctl00$MainContent$ddlList", "")
	                    .data("ctl00$MainContent$Slider1", "62")
	                    .data("ctl00$MainContent$Slider1_Boundcontrol", "100")
	                    .data("ctl00$MainContent$btnSearch","Search")
	                    .cookies(connection.cookies())
	                    .followRedirects(true)
	                    .execute();
	            
	            //parse the document from response
	            Document document = response.parse();
	            
	            System.out.println("doc title2"+document.title());
	            Element result = document.select("div#ctl00_MainContent_divResults").first();
	            
	            String text = document.body().text();
	      //      System.out.println(text);
	            System.out.println(result.text());
	            ArrayList<String> downServers = new ArrayList<>();
	            Element table = document.select("#gvSearchResults").get(0); //select the first table.
	            Elements rows = table.select("tr");
	            System.out.println("---- ");
	            for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
	                Element row = rows.get(i);
	                Elements cols = row.select("td");
	                String h = cols.html();
	                
	                
	                System.out.println(extractId(h) + " "+ cols.get(0).text());
				/*
				 * int posy = h.indexOf("&quot;"); int posx
				 * =h.indexOf("Details.aspx?id=")+"Details.aspx?id=".length();
				 * System.out.println(h.indexOf("&quot;"));
				 * System.out.println(h.substring(posx,h.length()-posy));
				 */
	                
				/*
				 * System.out.println(cols.get(0).text());
				 */
	                /*
														 * if (cols.get(7).text().equals("down")) {
														 * downServers.add(cols.get(5).text()); }
														 */
	            }
	            //get cookies
	           // Map<String, String> mapCookies = response.cookies();
	            
	            /*
	             * You may need to send all the cookies you received
	             * from the post response to the subsequent requests.
	             * 
	             * You can do that using cookies method of Connection
	             */
	            
	            
	            
	        }catch(IOException ioe){
	            System.out.println("Exception: " + ioe);
	        }
	        
	        
	        
	}
	public static String extractId(String content) {
		 Pattern pattern =  
			        Pattern.compile("id=([0-9]+)", Pattern.CASE_INSENSITIVE); 
		    Matcher m = pattern.matcher(content); 
			  	
		    String id = "";
		    while (m.find()) {
		    	id = m.group(1);
		    	
	        }
		    
		    return id;

	}

}

