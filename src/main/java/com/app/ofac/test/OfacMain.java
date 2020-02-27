package com.app.ofac.test;

import java.util.List;

import com.app.ofac.Ofac;
import com.app.ofac.model.OfacAddress;
import com.app.ofac.model.OfacAlias;
import com.app.ofac.model.OfacIdentification;
import com.app.ofac.model.OfacResult;
import com.app.ofac.model.OfacResultDetail;

public class OfacMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stubo
		Ofac ofac = new Ofac();
		
		  try { 
	  	   ofac.setTimeout(100000);
			List<OfacResult> results = ofac.search("", "Muhammad Iqbal", "29553654234",
		  "", 92,"", "", "", "", ""); 
		System.out.println("Total Finding:"+results.size());
		System.out.println("From The Website:"+ofac.getResultOnText());
		for(OfacResult r:results){
			  System.out.println(r.getName()+" "+r.getType()+" "+r.getAddress()+" " +r.getProgram()+" "+r.getScore());
		  }
		  System.out.println("TotalTime:"+ofac.getGetTotalSearchTime()+" ms");
		  
		  }catch(Exception e) {
			  
		  }/*
		
		try {
			OfacResultDetail ofacDetail = ofac.findByOfacId(2791);

			System.out.println("detail:");
			System.out.println(ofacDetail.getDetails().getType());
			System.out.println(ofacDetail.getDetails().getFirstName());
			System.out.println(ofacDetail.getDetails().getEntityName());
			System.out.println(ofacDetail.getDetails().getProgram());
			

			System.out.println("alias:");
			for(OfacAlias alias :ofacDetail.getAliases()) {
				System.out.println(alias.getCategory());
			}
			
			System.out.println("identification:");
			for(OfacIdentification alias :ofacDetail.getIdentifications()) {
				System.out.println(alias.getId());
			}
			
			
			System.out.println("address:");
			for(OfacAddress address :ofacDetail.getAddresses()) {
				System.out.println(address.getAddress());
			}
			System.out.println(ofacDetail.getEndInMillis() - ofacDetail.getStartInMillis());
			
			
		}catch(Exception e) {
			
		}*/
		
	}

}
