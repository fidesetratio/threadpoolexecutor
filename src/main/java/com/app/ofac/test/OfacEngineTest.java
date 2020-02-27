package com.app.ofac.test;

import java.util.List;
import java.util.Scanner;

import com.app.ofac.Ofac;
import com.app.ofac.model.OfacResult;

public class OfacEngineTest {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 String name = "";
		 Ofac ofac = new Ofac();
		 
		 do {
			 
			 try{
			    System.out.println("Please input name to search?");
			    System.out.print("> ");
			    ofac.setTimeout(10*10000);
			    name = sc.next();		    
			    
				System.out.println("Searching...");
				List<OfacResult> results = ofac.search("", name, "",
						  "", 82,"", "", "", "", ""); 
			
				System.out.println("Search with name: "+name);
				System.out.println("Total Finding:"+results.size());
				System.out.println("From The Website:"+ofac.getResultOnText());
				int i = 1;
				for(OfacResult r:results){
					  System.out.println(i+". "+r.getOfacId()+" "+r.getName()+" "+r.getType()+" "+r.getAddress()+" " +r.getProgram()+" "+r.getScore());
					  i++;
				}
				  System.out.println("TotalTime:"+ofac.getGetTotalSearchTime()+" ms");
				  System.out.println("   ");
				  
			 }catch(Exception e){
				 e.printStackTrace();
				 System.out.println("There is a connection error. Please contact your administrator "+e.getMessage());
			 }
			    
		 } while ((!name.toLowerCase().equals("done")) && (!name.toLowerCase().equals("exit")));
		 
		 sc.close();
	}

}
