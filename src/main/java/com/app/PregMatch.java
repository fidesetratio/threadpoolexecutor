package com.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PregMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = "<a id=\"btnDetails\" href=\"javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(&quot;ctl00$MainContent$gvSearchResults$ctl790$btnDetails&quot;, &quot;&quot;, false, &quot;&quot;, &quot;Details.aspx?id=7689&quot;, false, true))\" style=\"color:Blue\">RA'D, Muhammad</a>\n";
		 Pattern pattern =  
			        Pattern.compile("id=([0-9]+)", Pattern.CASE_INSENSITIVE); 
			  
			        // Search above pattern in "geeksforgeeks.org" 
			        Matcher m = pattern.matcher(content); 
			  
			        // Print starting and ending indexes of the pattern 
			        // in text 
			        while (m.find()) {
			        	//System.out.println("content"+content.substring(m.start(),m.end()-1));
			        
			/*
			 * System.out.println("Pattern found from " + m.start() + " to " + (m.end()-1));
			 */
			        	 System.out.println(m.group(1));
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
