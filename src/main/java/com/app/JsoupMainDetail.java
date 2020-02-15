package com.app;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupMainDetail {
	

	public static void main(String args[]) throws IOException {
		 String url = "https://sanctionssearch.ofac.treas.gov/";
	       url=url+"Details.aspx?id=4281";
	       Connection.Response  connection = Jsoup.connect(url).method(Connection.Method.GET).execute();
		 
		  Document doc = connection.parse();
		  Element table = doc.select("#ctl00_MainContent_pnlDetailsInd table").get(0); //select the first table.
		   Elements rows = table.select("tr");
           System.out.println("---- "+rows.size());
           for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
               Element row = rows.get(i);
               Elements cols = row.select("td");
               System.out.println(cols.get(0).text()+"--"+cols.get(1).text());
               System.out.println(" ");
               try {
               System.out.println(cols.get(2).text()+"--"+cols.get(3).text());
               }catch(IndexOutOfBoundsException e) {
            	   
               }
               
           };
           
           
            table = doc.select("#ctl00_MainContent_gvIdentification").get(0); //select the first table.
		   rows = table.select("tr");
           System.out.println("---- "+rows.size());
           for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
               Element row = rows.get(i);
               Elements cols = row.select("td");
              // System.out.println(cols.html());
               //break;
              try {
               System.out.println(cols.get(1).html());
              }catch(IndexOutOfBoundsException e) {
            	  
              }
           };
           
           table = doc.select("#ctl00_MainContent_gvAliases").get(0); //select the first table.
		   rows = table.select("tr");
           System.out.println("---- "+rows.size());
           for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
               Element row = rows.get(i);
               Elements cols = row.select("td");
              // System.out.println(cols.html());
               //break;
              try {
               System.out.println(cols.get(1).html());
              }catch(IndexOutOfBoundsException e) {
            	  
              }
           };
	}
	
}
